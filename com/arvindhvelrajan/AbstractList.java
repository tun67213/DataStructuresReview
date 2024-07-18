package com.arvindhvelrajan;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for this class
 */
public class AbstractList<E> extends AbstractCollection<E> implements List<E>
{
    /**
     * @code Constructor for this class
     */
    protected AbstractList()
    {

    }

    /**
     * @param e the value to be added to this list
     * @throws UnsupportedOperationException if the add operation is not supported by
     *         this list
     * @return true
     */
    @Override
    public boolean add(E e)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @param index   the location at which to add the provided value
     * @param element the value to be added to the specified location in this List
     */
    @Override
    public void add(int index, E element)
    {

    }

    /**
     * @param index The location at which to add the specified collection
     * @param c     Collection of values to be added to this List
     * @return true if everything is successful, false if collection is empty
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        return false;
    }

    /**
     * @param index the location at which to retrieve the value from
     * @throws IndexOutOfBoundsException if index is out of range
     * @return the element at the specified index
     */
    @Override
    public E get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    /**
     * @param index the location at which to replace an element
     * @param element the value to be replaced with at the specified location
     * @throws ClassCastException if the class of the adding element is not same as class of List
     * @throws NullPointerException if no replacement value is provided
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @return the previous value at the specified location
     */
    @Override
    public E set(int index, E element)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @return an Iterator for this Abstract List
     */
    @Override
    public Iterator<E> iterator()
    {
        return null;
    }

    /**
     * @param o the Object to find the location of the last occurrence of
     * @throws NullPointerException if no Object is provided
     * @return the location of the last occurrence of the provided Object
     */
    @Override
    public int lastIndexOf(Object o)
    {
        return 0;
    }

    /**
     * @return a List Iterator representing this class
     */
    @Override
    public ListIterator<E> listIterator()
    {
        return null;
    }

    /**
     * @param index the location at which to start the List Iterator
     * @throws IndexOutOfBoundsException if index is provided, but out of bounds
     * @return a List Iterator representing this class, starting at the specified index
     */
    @Override
    public ListIterator<E> listIterator(int index)
    {
        return null;
    }

    /**
     * @param index the location at which to remove a value
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @return the value previously at the specified index
     * @code Removes and returns the value at the specified index
     */
    @Override
    public E remove(int index)
    {
        return null;
    }

    /**
     * @return the number of elements in this Abstract List
     */
    @Override
    public int size()
    {
        return 0;
    }

    /**
     * @param fromIndex the starting location from which to create this subList
     * @param toIndex the ending location from which to create this subList
     * @throws IndexOutOfBoundsException if indexes are provided, but are out of bounds
     * @throws IllegalArgumentException if fromIndex is greater than toIndex
     * @return a mini-List with the specified indexes
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex)
    {
        return null;
    }
}
