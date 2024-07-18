package com.arvindhvelrajan;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for this Interface
 */
public interface Collection<E> extends Iterable<E>
{
    /**
     * @param e Value to be added to this Collection
     * @throws NullPointerException if no value is provided
     * @return true if no exceptions are thrown and value is added successfully
     * @code Adds the specified element to this Collection
     */
    boolean add(E e);

    /**
     * @param c Collection of values to add to this Collection
     * @throws NullPointerException if no Collection is provided
     * @return true if this Collection has values that are successfully added, false otherwise
     * @code Adds all the elements in the specified collection to this collection
     */
    boolean addAll(Collection<? extends E> c);

    /**
     * @code Removes all the elements from this collection
     */
    void clear();

    /**
     * @param o the value to check for existence in this Collection
     * @throws NullPointerException if no value is provided
     * @return true if the provided value is found, false otherwise
     * @code Returns true if this collection contains the specified element
     */
    boolean contains(Object o);

    /**
     * @param c Collection of values to check for existence in this Collection
     * @throws NullPointerException if no collection of values is provided
     * @return true if all values have been found, false otherwise
     * @code Returns true if this collection contains all the elements in the specified collection
     */
    boolean containsAll(Collection<?> c);

    /**
     * @param o the Object to compare for equality for this Collection
     * @throws NullPointerException if no Object is provided
     * @return true if the Objects are the same, false otherwise
     * @code Compares the specified object with this Collection for equality
     */
    @Override
    boolean equals(Object o);

    /**
     * @return the hash code value for this collection
     */
    @Override
    int hashCode();

    /**
     * @return true if this Collection is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * @return an iterator over the elements in this collection
     */
    @Override
    Iterator<E> iterator();

    /**
     * @param o the Object to find and remove the first occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if the Collection has been modified, false otherwise
     * @code Removes the first occurrence of the provided object and returns true if found,
     *       false if not found
     */
    boolean remove(Object o);

    /**
     * @param c Collection of values to remove if found
     * @throws NullPointerException if no Collection is provided
     * @return true if this Collection has been modified, false otherwise
     * @code Removes all the elements in the provided Collection that are found in this Collection
     */
    boolean removeAll(Collection<?> c);

    /**
     * @param c Collection of values to keep if found
     * @throws NullPointerException if no Collection is provided
     * @return true if this Collection has been modified, false otherwise
     * @code Keeps all the elements in the provided Collection that are found in this Collection,
     *       and removes values that aren't found in the provided Collection
     */
    boolean retainAll(Collection<?> c);

    /**
     * @return the number of elements in this Collection
     */
    int size();

    /**
     * @return an array containing all the elements in this Collection
     */
    Object[] toArray();

    /**
     * @param <T> the runtime type of the array to contain the collection
     * @param a the array into which the elements of the collection are to be stored,
     *          if it is big enough; otherwise, a new array of the same runtime type
     *          is allocated for this purpose
     * @throws ArrayStoreException if the runtime of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this collection
     * @throws NullPointerException if the specified array is null
     * @return an array containing all the elements in this Collection
     */
    <T> T[] toArray(T[] a);
}
