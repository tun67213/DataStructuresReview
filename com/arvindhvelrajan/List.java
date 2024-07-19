package com.arvindhvelrajan;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for this class
 */
public interface List<E> extends Collection<E>
{
    /**
     * @param e the value to be added to this List
     * @return true if this value is added without any exceptions
     * @throws NullPointerException if no value is provided
     * @code Adds the specified value to the end of this List
     */
    @Override
    boolean add(E e);

    /**
     * @param index   the location at which to add the provided value
     * @param element the value to be added to the specified location in this List
     * @throws NullPointerException      if no value is provided
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @code Adds the specified value to the specified location in this List
     */
    void add(int index, E element);

    /**
     * @param c Collection of values to be added
     * @return true if the provided Collection is not empty and values are added,
     * false Collection is empty
     * @throws NullPointerException if no Collection is provided
     * @code Adds the values in the provided Collection to the end of this List in sequential order
     */
    @Override
    boolean addAll(Collection<? extends E> c);

    /**
     * @param index The location at which to add the specified collection
     * @param c     Collection of values to be added to this List
     * @return true if the index is within appropriate range and a proper collection
     * with values is provided, false if Collection is empty
     * @throws NullPointerException      if no Collection is provided
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @code Adds the values in the provided Collection to the specified location in this List in
     * sequential order
     */
    boolean addAll(int index, Collection<? extends E> c);

    /**
     * @code Removes all the elements from this List
     */
    @Override
    void clear();

    /**
     * @param o the Object to find and remove
     * @return true if this list contains the provided value, false otherwise
     * @throws NullPointerException if no Object is provided
     */
    @Override
    boolean contains(Object o);

    /**
     * @param c Collection of values to search the existence of in this List
     * @return true if the Collection has values and the values in the Collection are found in
     * this List, false otherwise
     * @throws NullPointerException if no Collection is provided
     */
    @Override
    boolean containsAll(Collection<?> c);

    /**
     * @param o the Object to compare for equality
     * @return true if the provided Object is exactly the same as this List
     * @throws NullPointerException if no Object is provided
     */
    @Override
    boolean equals(Object o);

    /**
     * @param index the location at which to retrieve the value from
     * @return the value at the provided index
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @code Returns the element at the specified index.
     */
    E get(int index);

    /**
     * @return the hash code value for this list
     */
    @Override
    int hashCode();

    /**
     * @param o the Object to find the location of the first occurrence of
     * @return the location of the first occurrence of the provided value or -1 if not found
     * @throws NullPointerException if no value is provided
     */
    int indexOf(Object o);

    /**
     * @return true if this list is empty, false otherwise
     */
    @Override
    boolean isEmpty();

    /**
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    Iterator<E> iterator();

    /**
     * @param o the Object to find the location of the last occurrence of
     * @return the location of the last occurrence of the provided value or -1 if not found
     * @throws NullPointerException if no value is provided
     */
    int lastIndexOf(Object o);

    /**
     * @return a list iterator over the elements in this list
     */
    ListIterator<E> listIterator();

    /**
     * @param index the location at which to start the List Iterator
     * @return a list iterator over the elements in this list starting at the provided index
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     */
    ListIterator<E> listIterator(int index);

    /**
     * @param index the location at which to remove a value
     * @return the value previously at the provided index
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @code The function removes and returns the value at the specified index in this List.
     */
    E remove(int index);

    /**
     * @param o the Object to find and remove the first occurrence of from this List
     * @return true if this List has been modified, false otherwise
     * @throws NullPointerException if no Object is provided
     * @code Finds and removes the first occurrence of the value provided, given that the user
     * provided it. If the item was not found, it returns false. If it WAS found and removed,
     * then the function returns true.
     */
    @Override
    boolean remove(Object o);

    /**
     * @param c Collection of values to remove if found
     * @return true if this List has been modified, false otherwise
     * @throws NullPointerException if no Collection is provided
     * @code Removes from the list all its elements that are contained in the specified Collection
     */
    @Override
    boolean removeAll(Collection<?> c);

    /**
     * @param c Collection of values to keep if found
     * @return true if this List has been modified, false otherwise
     * @throws NullPointerException if no Collection is provided
     * @code Keeps in this list all its elements that are contained in the specified Collection
     */
    @Override
    boolean retainAll(Collection<?> c);

    /**
     * @param index   the location at which to change values
     * @param element the value to use as replacement
     * @return the previous value at the specified index
     * @throws NullPointerException      if no value is provided as replacement
     * @throws IndexOutOfBoundsException if index is provided but out of bounds
     * @code Replaces the value already existent with the provide value, returning
     * value that was previously there
     */
    E set(int index, E element);

    /**
     * @return the number of elements in this list
     */
    @Override
    int size();

    /**
     * @param fromIndex the starting location from which to create this subList
     * @param toIndex   the ending location from which to create this subList
     * @throws IndexOutOfBoundsException if either is out of bounds
     * @throws IllegalArgumentException  if fromIndex is greater than toIndex
     */
    List<E> subList(int fromIndex, int toIndex);

    /**
     * @return an array containing all the elements in this list in proper sequence
     */
    @Override
    Object[] toArray();

    /**
     * @param <T> New Generic return type matching that of the specified array
     * @param a   array into which to copy the elements in this List
     * @return an array containing all the elements in this list in proper sequence; runtime type
     * of the returned array is that of the specified array
     * @throws NullPointerException if no array 'a' is provided
     */
    @Override
    <T> T[] toArray(T[] a);

    /**
     * @return a String representation of this List
     */
    @Override
    String toString();
}
