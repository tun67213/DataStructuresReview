package com.arvindhvelrajan;

import java.util.NoSuchElementException;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for this interface
 */
public interface Queue<E> extends Collection<E>
{
    /**
     * @param e The value to add to this Queue
     * @throws NullPointerException if no value is provided
     * @throws IllegalStateException if no space is available
     * @return true upon success
     * @code Inserts the specified element into this queue
     */
    @Override
    boolean add(E e);

    /**
     * @param e The value to offer to this Queue
     * @throws NullPointerException if no value is provided
     * @throws IllegalStateException if no space is available
     * @return true upon success
     * @code Inserts the specified element into the beginning of this queue
     */
    boolean offer(E e);

    /**
     * @return the head of the queue or null if empty
     * @code Retrieves, but does not remove, the head of the queue or returns null if the queue
     *       is empty
     */
    E peek();

    /**
     * @return the head of the Queue or null if the queue is empty
     */
    E poll();

    /**
     * @return the head of the Queue
     * @throws NoSuchElementException if the Queue is empty
     * @code Retrieves, but does not remove, the head of the queue, unless the queue is empty
     */
    E element();

    /**
     * @return the previous head of this Queue
     * @throws NoSuchElementException if the Queue is empty
     * @code Removes and returns the head of the queue
     */
    E remove();
}
