package com.arvindhvelrajan;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable to run this interface on any data type
 */
public interface Iterator<E>
{
    boolean hasNext();

    E next();

    void remove();
}
