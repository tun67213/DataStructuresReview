package com.arvindhvelrajan;

import java.util.NoSuchElementException;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for this class
 */
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable
{
    private class Node<E>
    {
        private Node<E> previous;
        private E data;
        private Node<E> next;

        public Node(E value)
        {
            this.previous = null;
            this.data = value;
            this.next = null;
        }
    }

    /**
     * @code Default constructor to initial an empty Linked List
     */
    public LinkedList()
    {

    }

    /**
     * @param c Collection of values to initialize this Linked List with
     * @throws NullPointerException if no Collection is provided
     * @code Initializes this Linked List with values from the provided Collection
     */
    public LinkedList(Collection<? extends E> c)
    {

    }

    /**
     * @param e the value to be added to the end of this Linked List
     * @throws NullPointerException if no value is provided
     * @return true if the value has been successfully added
     * @code Creates a Node for the provided element and links it to the
     *       end of this Linked List
     */
    @Override
    public boolean add(E e)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param index the location at which to add the provided element
     * @param element the value to be linked to this Linked List
     * @throws NullPointerException if no value is provided
     * @throws IndexOutOfBoundsException if index is provided, but out of bounds
     */
    @Override
    public void add(int index, E element)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param c the Collection of values to add to the end of this Linked List
     * @throws NullPointerException if no Collection is provided
     * @return true if the Collection is there and has values, false if the collection
     *         is empty
     * @code Adds the values in the provided collection to the end of this Linked List
     *       in the order returned by the Collection's iterator
     */
    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param index the location at which to start adding the Collection of values
     * @param c the Collection of values to add to this Linked List
     * @throws NullPointerException if no Collection is provided
     * @throws IndexOutOfBoundsException if Collection is provided, but index is out of
     *         bounds
     * @return true if there are no problems and all values are added to this Linked List
     *         false if this Collection is empty
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param e the value to be added as the head of this Linked List
     * @throws NullPointerException if no value is provided
     * @code Adds the provided value as the head node
     */
    public void addFirst(E e)
    {

    }

    /**
     * @param e the value to be added as the tail of this Linked List
     * @throws NullPointerException if no value is provided
     * @code Adds the provided value as the tail node
     */
    public void addLast(E e)
    {

    }

    /**
     * @code Creates a new Linked List, erasing all the values that were existent in it
     */
    @Override
    public void clear()
    {

    }

    /**
     * @return a shallow copy of this Linked List Object
     */
    @Override
    public Object clone()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param o the Object to find the existence of in this Linked List
     * @throws NullPointerException if no Object is provided
     * @return true if the Object is found, false otherwise
     */
    @Override
    public boolean contains(Object o)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return an Iterator that traverses from tail to head (i.e., in reverse order)
     */
    public Iterator<E> descendingIterator()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @throws NoSuchElementException if this Linked List is null
     * @return the value at the head Node in this Linked List
     */
    public E element()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param index the location at which to retrieve the value from
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @return the value at the provided index
     * @code Retrieves and returns the value in the Node at the provided index
     */
    @Override
    public E get(int index)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value at the head node in this Linked List
     */
    public E getFirst()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value at the tail node in this Linked List
     */
    public E getLast()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param o the Object to find the location of the first occurrence of
     * @return the location of the first occurrence of the provided value or -1 if not found
     * @throws NullPointerException if no value is provided
     */
    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return true if this list is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param o the Object to find the location of the last occurrence of
     * @return the location of the last occurrence of the provided value or -1 if not found
     * @throws NullPointerException if no value is provided
     */
    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return a list iterator over the elements in this list
     */
    @Override
    public ListIterator<E> listIterator()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param index the location at which to start the List Iterator
     * @return a list iterator over the elements in this list starting at the provided index
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     */
    @Override
    public ListIterator<E> listIterator(int index)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param e the value to add at the end of this Linked List
     * @throws NullPointerException if no value is provided
     * @return true if the value has been successfully added
     * @code Adds the specified element as the tail (last element) of this list
     */
    public boolean offer(E e)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param e the value to add at the beginning of this Linked List
     * @throws NullPointerException if no value is provided
     * @return true if no exceptions are thrown and the value is successfully added
     * @code Adds the specified value at the beginning of this LinkedList
     */
    public boolean offerFirst(E e)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param e the value to add at the end of this Linked List
     * @throws NullPointerException if no value is provided
     * @return true if no exceptions are thrown and the value is successfully added
     * @code Adds the specified value at the end of this Linked List
     */
    public boolean offerLast(E e)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value in the head node of this Linked List
     */
    public E peek()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the value in the head node of this Linked List or null if this list is empty
     */
    public E peekFirst()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the value in the tail node of this Linked List or null if this list is empty
     */
    public E peekLast()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value that was previously in the Node at head
     * @code Removes the Node at head, reassigning it to the next Node if existent. If
     *       the Node to be removed is the only Node, sets both head and tail to null
     *       with the size being reset to 0. If not, then the head pointer is moved to
     *       the Node pointed to by next in the previous head Node.
     */
    public E poll()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the value that was previously in the Node at head or null if this Linked
     *         List is empty
     * @code Removes the Node at head, reassigning it to the next Node if existent. If
     *       the Node to be removed is the only Node, sets both head and tail to null
     *       with the size being reset to 0. If not, then the head pointer is moved to
     *       the Node pointed to by next in the previous head Node.
     */
    public E pollFirst()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value that was previously in the Node at tail
     * @code Removes the Node at tail, reassigning it to the previous Node if existent. If
     *       the Node to be removed is the only Node, sets both head and tail to null
     *       with the size being reset to 0. If not, then the tail pointer is moved to
     *       the Node pointed to by previous in the previous tail Node.
     */
    public E pollLast()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the value previously at head in this Linked List
     * @code Pops an element from the stack represented by this list
     */
    public E pop()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param e the value to push onto the stack represented by this list
     * @throws NullPointerException if no value is provided
     * @code Adds the provided value to the top of the stack represented by this list
     */
    public void push(E e)
    {

    }

    /**
     * @return the value in the Node previous pointed to by head
     * @code Removes the Node pointed to by head. If it is the only value, reassigns
     *       head to null and tail to null. If not, reassigns it to the next value in
     *       this Linked List.
     */
    public E remove()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param index the location at which to remove a Node
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @return the value previously at the provided index
     * @code Removes and returns the value in the Node at the specified index.
     */
    @Override
    public E remove(int index)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param o the Object to find and remove the first occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if this Linked List has been modified, false otherwise
     * @code Removes the first occurrence of the specified Object in this List
     */
    @Override
    public boolean remove(Object o)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the first element from this list
     * @code Removes and returns the first element from this list
     */
    public E removeFirst()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param o the Object to find and remove the first occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if this Linked List has been modified, false otherwise
     * @code Removes the first occurrence of the provided Object if found, false if
     *       not found
     */
    public boolean removeFirstOccurrence(Object o)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the last element from this list
     * @code Removes and returns the last element from this list
     */
    public E removeLast()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param o the Object to find and remove the last occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if this Linked List has been modified, false otherwise
     * @code Removes the last occurrence of the provided Object if found, false if
     *       not found
     */
    public boolean removeLastOccurrence(Object o)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param c Collection of values to remove if found
     * @return true if this List has been modified, false otherwise
     * @throws NullPointerException if no Collection is provided
     * @code Removes from the list all its elements that are contained in the specified Collection
     */
    @Override
    public boolean removeAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param c Collection of values to keep if found
     * @return true if this List has been modified, false otherwise
     * @throws NullPointerException if no Collection is provided
     * @code Keeps in this list all its elements that are contained in the specified Collection
     */
    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param index   the location at which to change values
     * @param element the value to use as replacement
     * @return the previous value at the specified index
     * @throws NullPointerException      if no value is provided as replacement
     * @throws IndexOutOfBoundsException if index is provided but out of bounds
     * @code Replaces the value already existent with the provide value, returning
     * value that was previously there
     */
    public E set(int index, E element)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the number of elements in this list
     */
    @Override
    public int size()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param fromIndex the starting location from which to create this subList
     * @param toIndex   the ending location from which to create this subList
     * @throws IndexOutOfBoundsException if either is out of bounds
     * @throws IllegalArgumentException  if fromIndex is greater than 19
     */
    public List<E> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return an array containing all the elements in this list in proper sequence
     */
    @Override
    public Object[] toArray()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param <T> New Generic return type matching that of the specified array
     * @param a   array into which to copy the elements in this List
     * @return an array containing all the elements in this list in proper sequence; runtime type
     * of the returned array is that of the specified array
     * @throws NullPointerException if no array 'a' is provided
     */
    @Override
    public <T> T[] toArray(T[] a)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return a readable String representation of this Linked List
     */
    @Override
    public String toString()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
