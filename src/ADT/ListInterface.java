package ADT;

/**
 * @author All
 * @param <T>
 */
public interface ListInterface<T> extends Iterable<T> {
    
    // Add element in specific position
    public boolean add(int index, T element);
    // Add element into the list
    public boolean add(T element);
    // Add array element to doubly linked list
    public boolean add(T[] array);
    // Add a list into another list
    public boolean add(ListInterface<T> list);
    // Add element at the first position
    public boolean addFirst(T element);
    
    // Remove element at specific position
    public boolean remove(int index);
    // Remove specific element
    public boolean remove(T element);
    // Remove the first element
    public boolean removeFirst();
    // Remove the last element
    public boolean removeLast();
    
    // Go through the list from head to tail
    public void traverseForward();
    // Go through the list from tail to head
    public void traverseBackward();
    // Display all element in the list
    public void display();
    
    // Check if the element exists in the list
    public boolean contains(T element);
    // Check if the element has next
    public boolean hasNext(int index);
    // Get the element at specific position
    public T get(int index);
    // Get the first element in the list
    public T getFirst();
    // Get the next element in the list
    public T getNext(int index);
    // Get the last element in the list
    public T getLast();
    
    // Get the index of the specific element
    public int indexOf(T element);
    // Get the last index of the element
    public int lastIndexOf(T element);
    
    // Replace / Update the element at the specific position
    public T set(int index, T element);

    
    // Check whether the list is empty
    public boolean isEmpty();
    // Get the size of the list
    public int size();
    // Clear the list
    public void clear();
    
    // Swap the element
    public void swap(int i, int j);
    
    // Search for the element
    public boolean search(T object1, T object2);
    
    // Search with fuzzy matching
    public int fuzzyMatching(T s1, T s2);
    
    @Override
    public String toString();
}