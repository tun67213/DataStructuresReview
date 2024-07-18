package com.arvindhvelrajan;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable to run this interface on any data type
 */
public interface Iterator<E>
{
    /**
     * @return true if the iteration has more elements, false otherwise
     */
    boolean hasNext();

    /**
     * @return the next element in the iteration
     */
    E next();

    /**
     * @code Removes from the underlying collection the last element returned by the iterator
     */
    void remove();
}
