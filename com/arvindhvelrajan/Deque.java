package com.arvindhvelrajan;

import java.util.NoSuchElementException;

/**
 * @author arvindhvelrajan
 * @param <E> Generic Variable
 */
public interface Deque<E>
{
    /**
     * @param e Value to be added to this Queue
     * @throws NullPointerException if no value is provided
     * @return true after successfully adding the value
     */
    @Override
    boolean add(E e);

    /**
     * @param e value to add to the beginning of this Queue
     * @throws NullPointerException if no value is provided
     * @code Adds the provided value to the beginning of this Queue
     */
    void addFirst(E e);

    /**
     * @param e value to add to the end of this Queue
     * @throws NullPointerException if no value is provided
     * @code Adds the provided value to the end of this Queue
     */
    void addLast(E e);

    /**
     * @param o the value to check for existence in this Collection
     * @throws NullPointerException if no value is provided
     * @return true if found, false otherwise
     */
    @Override
    boolean contains(Object o);

    /**
     * @return an iterator that traverses backwards
     */
    Iterator<E> descendingIterator();

    /**
     * @return the head element in this Queue
     * @code Retrieves, but does not remove, the head element
     */
    @Override
    E element();

    /**
     * @return the first element in this queue
     * @code Retrieves the first element in this queue
     */
    E getFirst();

    /**
     * @return the last element in this queue
     * @code Retrieves the last element in this queue
     */
    E getLast();

    /**
     * @return an iterator that traverses the list in this deque in proper sequence
     */
    @Override
    Iterator<E> iterator();

    /**
     * @param e The value to offer to this Queue
     * @throws NullPointerException if no value is provided
     * @return true if value is provided and successfully added
     */
    @Override
    boolean offer(E e);

    /**
     * @param e value to be offered to the beginning of this Queue
     * @throws NullPointerException if no value is provided
     * @return true if value is provided and no exceptions are therefore thrown
     * @code Adds the element provided as the first element
     */
    boolean offerFirst(E e);

    /**
     * @param e value to be offered to the end of this Queue
     * @throws NullPointerException if no value is provided
     * @return true if value is provided and no exceptions are therefore thrown
     * @code Adds the element provided as the last element
     */
    boolean offerLast(E e);

    /**
     * @return the first element in this queue
     */
    @Override
    E peek();

    /**
     * @return the first element in this queue
     */
    E peekFirst();

    /**
     * @return the last element in this queue
     */
    E peekLast();

    /**
     * @return the removed first element
     * @code Removes the first element in the Queue and returns it
     */
    @Override
    E poll();

    /**
     * @return the removed first element
     * @code Removes the first element in the Queue and returns it
     */
    E pollFirst();

    /**
     * @return the removed last element
     * @code Removes the last element in the Queue and returns it
     */
    E pollLast();

    /**
     * @return the first element in the stack represented by this deque
     * @code Pops an element from the stack represented by this deque
     */
    E pop();

    /**
     * @param e the element to be pushed into the stack represented by this deque
     * @throws NullPointerException if no element is provided
     * @code Pushes an element onto the stack represented by this deque if possible to do so
     */
    void push(E e);

    /**
     * @return the head of the queue represented by this deque
     * @code Removes and returns the head of the queue represented by this deque
     */
    @Override
    E remove();

    /**
     * @param o the Object to find and remove the first occurrence of
     * @throws NullPointerException if no Object has been provided
     * @return true if this Queue has been modified, false otherwise
     * @code Removes the first occurrence of the provided Object if found.
     *       Returns true if the list has been modified, false otherwise
     */
    @Override
    boolean remove(Object o);

    /**
     * @throws NoSuchElementException if Queue is empty
     * @return the previous first value in this Queue
     * @code Removes the first value from the beginning of this list and returns it
     */
    E removeFirst();

    /**
     * @param o the Object to find and remove the first occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if this Queue has been modified, false otherwise
     * @code Removes the first occurrence of the specified Object if provided and found,
     *       false if not found
     */
    boolean removeFirstOccurrence(Object o);

    /**
     * @throws NoSuchElementException if Queue is empty
     * @return the previous last value in this Queue
     * @code Removes the first value from the end of this list and returns it
     */
    E removeLast();

    /**
     * @param o the Object to find and remove the last occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if this Queue has been modified, false otherwise
     * @code Removes the last occurrence of the specified Object if provided and found,
     *       false if not found
     */
    boolean removeLastOccurrence(Object o);

    /**
     * @return the current size of this list
     */
    @Override
    int size();
}
