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
    
    // Define important variables
    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;

    // Constructor for the DoublyLinkedList
    public DoublyLinkedList() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }
    
    //---------------------------Add Operation---------------------------

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
    
    //---------------------------Delete Operation---------------------------
    
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
    
    //---------------------------Update Operation---------------------------
    
    @Override
    public T set(int index, T element) {
        Node node = getNodeAt(index);
        T oldData = node.data;
        node.data = element;
        return oldData;
    }

    //---------------------------Check if exist---------------------------
    
    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    //---------------------------Get Operation---------------------------
    
    @Override
    public T get(int index) {
        return getNodeAt(index).data;
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        for (Node current = firstNode; current != null; current = current.next, index++) {
            if (current.data.equals(element)) return index;
        }
        return -1;
    }

    //-----------------Necessary Operation---------------------------
    
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public void clear() {
        firstNode = lastNode = null;
        numberOfEntries = 0;
    }

    //---------------------------Extra Operation---------------------------

    @Override
    public void swap(int i, int j) {
        if (i == j) return; 

        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }
    
    @Override
    public boolean search(T data, T input){
        boolean match = false;
        
        if(data == null || input == null){
            return match;
        }
        
        String text = data.toString();
        String pattern = input.toString();
        int[ ] lps = computeLPS(pattern);
        int i = 0, j = 0;
        
        while(i < text.length()){
           if(text.charAt(i) == pattern.charAt(j)){
               i++;
               j++;
               if(j == pattern.length()){
                   match = true;
                   return match;
                }       
            } else if (j > 0){
                j = lps[j-1];
            } else {
                 i++;
            }
        }
        return match;
    }
    
    @Override
    // Fuzzy matching for string
    public int fuzzyMatching(T s1, T s2){
        if(s1 == null || s2 == null){
            return 0;
        }
        
        String string1 = s1.toString();
        String string2 = s2.toString();
        
        int m = string1.length(), n = string2.length();
        int[][]dp = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i==0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (string1.charAt(i - 1) == string2.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }
    
    //---------------------------Helper Function---------------------------
     
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
    
    // Calculate the LPS Distance
    private int[] computeLPS(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
        int j = 0;
        
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = ++j;
            }
        }
        return lps;
    }
    
    //---------------------------Iterator Function---------------------------
    
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
    
    //---------------------------Node Class---------------------------
    
    private class Node {
        private T data;
        private Node prev, next;
        private Node(T data) { this.data = data; }
    }
}
