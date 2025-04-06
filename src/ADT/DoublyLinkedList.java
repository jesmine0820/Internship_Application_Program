package ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author All
 * @param <T>
 * 
 */

public class DoublyLinkedList<T extends Comparable<T>> implements ListInterface<T> {
    
    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;
    
    // Constructor for the DoublyLinkedList
    public DoublyLinkedList() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T element) {
        if (element == null) return false;
        Node newNode = new Node(element);
        if (isEmpty()) {
            firstNode = lastNode = newNode;
        } else {
            lastNode.next = newNode;
            newNode.prev = lastNode;
            lastNode = newNode;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (element == null || checkOutOfRange(index, true)) {
            return false;
        }
        Node newNode = new Node(element);
        if (index == 0) {
            return addFirst(element);
        } else if (index == numberOfEntries) {
            return add(element);
        } else {
            Node current = getNodeAt(index);
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
            numberOfEntries++;
        }
        return true;
    }
    
    @Override
    public boolean add(T[] array){
        if (array.length == 0){
            return false;
        } 
        
        for (T element: array){
            add(element);
        }
        
        return true;
    }
    
    @Override
    public boolean add(ListInterface<T> list){
        if(list.isEmpty()){
            return false;
        } else {
            for(int i = 0; i < list.size(); i++){
                add(list.get(i));
            }
            return true;
        }
    }

    @Override
    public boolean addFirst(T element) {
        if (element == null) return false;
        Node newNode = new Node(element);
        if (isEmpty()) {
            firstNode = lastNode = newNode;
        } else {
            newNode.next = firstNode;
            firstNode.prev = newNode;
            firstNode = newNode;
        }
        numberOfEntries++;
        return true;
    }
    
    @Override
    public boolean remove(int index) {
        if (checkOutOfRange(index, false)) return false;
        Node toRemove = getNodeAt(index);
        removeNode(toRemove);
        return true;
    }

    @Override
    public boolean remove(T element) {
        Node current = firstNode;
        while (current != null) {
            if (current.data.equals(element)) {
                removeNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void removeNode(Node toRemove) {
        if (toRemove == firstNode) {
            removeFirst();
        } else if (toRemove == lastNode) {
            removeLast();
        } else {
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;
            numberOfEntries--;
        }
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) return false;
        firstNode = firstNode.next;
        if (firstNode != null) {
            firstNode.prev = null;
        } else {
            lastNode = null;
        }
        numberOfEntries--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()) return false;
        lastNode = lastNode.prev;
        if (lastNode != null) {
            lastNode.next = null;
        } else {
            firstNode = null;
        }
        numberOfEntries--;
        return true;
    }
    
    @Override
    public T set(int index, T element) {
        Node node = getNodeAt(index);
        T oldData = node.data;
        node.data = element;
        return oldData;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }
    
    @Override
    public boolean hasNext(int index){
        return get(index+1) != null;
    }

    @Override
    public T get(int index) {
        return getNodeAt(index).data;
    }

    @Override
    public T getFirst() {
        return isEmpty() ? null : firstNode.data;
    }
    
    @Override
    public T getNext(int index){
        return isEmpty() ? null : get(index+1);
    }

    @Override
    public T getLast() {
        return isEmpty() ? null : lastNode.data;
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        for (Node current = firstNode; current != null; current = current.next, index++) {
            if (current.data.equals(element)) return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        int index = numberOfEntries - 1;
        for (Node current = lastNode; current != null; current = current.prev, index--) {
            if (current.data.equals(element)) return index;
        }
        return -1;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public void clear() {
        firstNode = lastNode = null;
        numberOfEntries = 0;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node current = firstNode;
            @Override public boolean hasNext() { return current != null; }
            @Override public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public void traverseForward() {
        for (Node current = firstNode; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }
    
    @Override
    public void display() {
        Node temp = firstNode;
        while (temp != null) {
            System.out.println(temp.data); 
            temp = temp.next;
        }
    }

    @Override
    public void traverseBackward() {
        for (Node current = lastNode; current != null; current = current.prev) {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }
    
    @Override
    public void swap(int i, int j) {
        if (i == j) return; 

        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    // Check whether the index is out of range
    private boolean checkOutOfRange(int index, boolean allowSize) {
        return index < 0 || index > numberOfEntries - (allowSize ? 0 : 1);
    }

    // Get the node at a specific position
    private Node getNodeAt(int index) {
        if (index < numberOfEntries / 2) {
            Node current = firstNode;
            for (int i = 0; i < index; i++) current = current.next;
            return current;
        } else {
            Node current = lastNode;
            for (int i = numberOfEntries - 1; i > index; i--) current = current.prev;
            return current;
        }
    }
    
    private class Node {
        private T data;
        private Node prev, next;
        private Node(T data) { this.data = data; }
    }
}
