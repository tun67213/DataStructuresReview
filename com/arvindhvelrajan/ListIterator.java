package com.arvindhvelrajan;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for this Interface
 */
public interface ListIterator<E> extends Iterator<E>
{
    /**
     * @param e value to be added into the list
     * @throws NullPointerException if no value is provided
     * @code Inserts the specified element into this list
     */
    void add(E e);

    /**
     * @return true if this list iterator has more elements when traversing in the
     *         forward direction, false otherwise
     */
    @Override
    boolean hasNext();

    /**
     * @return true if this list iterator has more elements when traversing in the
     *         reverse direction, false otherwise
     */
    boolean hasPrevious();

    /**
     * @return the next element in the list
     * @code Returns the next element in the list, and moves the pointer to the next value
     */
    @Override
    E next();

    /**
     * @return the index of the element to be returned by a subsequent call to next()
     */
    int nextIndex();

    /**
     * @return the previous element in the list
     * @code Returns the previous element in the list, and moves the pointer to the previous
     *       value
     */
    E previous();

    /**
     * @return the index of the element to be returned by a subsequent call to previous()
     */
    int previousIndex();

    /**
     * @code Removes from the list the last element returned by next() or previous()
     */
    @Override
    void remove();

    /**
     * @param e the value to replace the old one with at the pointer
     * @throws NullPointerException if no replacement value is provided
     * @code Replaces the last element returned by next() or previous() with the specified
     *       element
     */
    void set(E e);
}
