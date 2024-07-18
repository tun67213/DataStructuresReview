package com.arvindhvelrajan;

/**
 * @author arvindhvelrajan
 * @param <T> Generic variable to run this interface on any data type
 */
public interface Iterable<T>
{
    /**
     * @return an iterator over a set of elements of type T
     */
    Iterator<T> iterator();
}
