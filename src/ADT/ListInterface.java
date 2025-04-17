package ADT;

import java.util.Iterator;

/**
 * @author All
 * @param <T>
 */
public interface ListInterface<T> extends Iterable<T> {
    
    //---------------------------Add Operation---------------------------
    // Add element into the list
    public boolean add(T element);
    // Add array element to doubly linked list
    public boolean add(T[] array);
    // Add a list into another list
    public boolean add(ListInterface<T> list);
    
    //---------------------------Delete Operation---------------------------
    // Remove element at specific position
    public boolean remove(int index);
    // Remove specific element
    public boolean remove(T element);
    // Remove the first element
    public boolean removeFirst();
    // Remove the last element
    public boolean removeLast();
    
    //---------------------------Update Operation---------------------------
    // Replace / Update the element at the specific position
    public T set(int index, T element);
    
    //---------------------------Check if exist---------------------------
    // Check if the element exists in the list
    public boolean contains(T element);
    
    //---------------------------Get Operation---------------------------
    // Get the element at specific position
    public T get(int index);
    // Get the index of the specific element
    public int indexOf(T element);
    
    //-----------------Necessary Operation---------------------------
    // Check whether the list is empty
    public boolean isEmpty();
    // Get the size of the list
    public int size();
    // Clear the list
    public void clear();
    
    //---------------------------Extra Operation---------------------------
    // Swap the two element
    public void swap(int i, int j);
    // Search for the element
    public boolean search(T object1, T object2);
    // Search with fuzzy matching
    public int fuzzyMatching(T s1, T s2);
    
    //---------------------------Convert to String---------------------------
    @Override
    public String toString();
    
    @Override
    public Iterator<T> iterator();
}