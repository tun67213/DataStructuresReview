package com.arvindhvelrajan;

import java.util.NoSuchElementException;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for class
 */
public class ArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable
{
    private int size;
    private int capacity;
    private E[] array;

    /**
     * @code Creates an empty ArrayList with default values for variables
     */
    @SuppressWarnings("unchecked")
    public ArrayList()
    {
        this.size = 0;
        this.capacity = 10;
        this.array = (E[]) new Object[this.capacity];
    }

    /**
     * @param c Collection of values to initialize this ArrayList with
     * @throws NullPointerException if no Collection of values is provided
     * @code Initializes this ArrayList with values from the provided Collection
     */
    @SuppressWarnings("unchecked")
    public ArrayList(Collection<? extends E> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a collection of values to initialize this ArrayList with");
        }
        this.size = 0;
        this.capacity = c.size() + c.size() / 2;
        this.array = (E[]) new Object[this.capacity];
        Iterator<? extends E> iterator = c.iterator();
        while(iterator.hasNext())
        {
            this.array[this.size] = iterator.next();
            this.size++;
        }
    }

    /**
     * @code Ensures that the array has enough space and if not, reallocates
     *       the values in this array into a new one
     */
    @SuppressWarnings("unchecked")
    public void ensureCapacity()
    {
        if(this.size == this.capacity)
        {
            int newCapacity = this.capacity + this.capacity / 2;
            E[] newArray = (E[]) new Object[newCapacity];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.capacity = newCapacity;
            this.array = newArray;
        }
    }

    /**
     * @param e the value to be added to this List
     * @return true if this value is added without any exceptions
     * @throws NullPointerException if no value is provided
     * @code Adds the specified value to the end of this List
     */
    @Override
    public boolean add(E e)
    {
        if(e == null)
        {
            throw new NullPointerException("You MUST provide a value to add to this ArrayList");
        }
        ensureCapacity();
        this.array[this.size] = e;
        this.size++;
        return true;
    }

    /**
     * @param index   the location at which to add the provided value
     * @param element the value to be added to the specified location in this List
     * @throws NullPointerException      if no value is provided
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @code Adds the specified value to the specified location in this List
     */
    @Override
    public void add(int index, E element)
    {
        if(element == null)
        {
            throw new NullPointerException("You MUST provide a value to add to this ArrayList");
        }
        if(index < 0 || index > this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        ensureCapacity();
        for(int i = this.size; i > index; i--)
        {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = element;
        this.size++;
    }

    /**
     * @param c Collection of values to be added
     * @return true if the provided Collection is not empty and values are added,
     * false Collection is empty
     * @throws NullPointerException if no Collection is provided
     * @code Adds the values in the provided Collection to the end of this List in sequential order
     */
    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a Collection of values to add to this ArrayList");
        }
        if(c.isEmpty())
        {
            return false;
        }
        Iterator<? extends E> iterator = c.iterator();
        while(iterator.hasNext())
        {
            this.array[this.size] = iterator.next();
            this.size++;
        }
        return true;
    }

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
    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a Collection of values to add to this ArrayList");
        }
        if(index < 0 || index > this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if(c.isEmpty())
        {
            return false;
        }
        E[] values = (E[]) c.toArray();
        for(int i = values.length - 1; i >= 0; i--)
        {
            ensureCapacity();
            for(int j = this.size; j > index; j--)
            {
                this.array[j] = this.array[j - 1];
            }
            this.array[index] = values[i];
            this.size++;
        }
        return true;
    }

    /**
     * @code Removes all the elements from this List
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear()
    {
        this.size = 0;
        this.capacity = 10;
        this.array = (E[]) new Object[this.capacity];
    }

    /**
     * @return a shallow copy of this ArrayList object
     */
    @Override
    public Object clone()
    {
        ArrayList<E> list = new ArrayList<>();
        for(int i = 0; i < this.size; i++)
        {
            list.add(this.array[i]);
        }
        return list;
    }

    /**
     * @param o the Object to find and remove
     * @return true if this list contains the provided value, false otherwise
     * @throws NullPointerException if no Object is provided
     */
    @Override
    public boolean contains(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a value to find the existence of in this ArrayList");
        }
        for(int i = 0; i < this.size; i++)
        {
            if(this.array[i].equals(o))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @param c Collection of values to search the existence of in this List
     * @return true if the Collection has values and the values in the Collection are found in
     * this List, false otherwise
     * @throws NullPointerException if no Collection is provided
     */
    @Override
    public boolean containsAll(Collection<?> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a collection of values to find the existence of in this ArrayList");
        }
        if(c.isEmpty())
        {
            return true;
        }
        Iterator<?> iterator = c.iterator();
        boolean found = false;
        while(iterator.hasNext())
        {
            Object value = iterator.next();
            for(int i = 0; i < this.size; i++)
            {
                if(this.array[i].equals(value))
                {
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * @param o the Object to compare for equality
     * @return true if the provided Object is exactly the same as this List
     * @throws NullPointerException if no Object is provided
     */
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a Data Structure to compare with this one");
        }
        if(!(o instanceof ArrayList))
        {
            throw new ClassCastException("You MUST provide an ArrayList to compare with this one for equality");
        }
        if(this == o)
        {
            return true;
        }
        ArrayList<?> other = (ArrayList<?>) o;
        if(this.size != other.size)
        {
            return false;
        }
        for(int i = 0; i < this.size; i++)
        {
            if(!(this.array[i].equals(other.array[i])))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * @param index the location at which to retrieve the value from
     * throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @return the value at the provided index
     * @code Returns the element at the specified index.
     */
    public E get(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return this.array[index];
    }

    /**
     * @return the hash code value for this list
     */
    @Override
    public int hashCode()
    {
        int hashcode = 1;
        for(int i = 0; i < this.size; i++)
        {
            E item = this.array[i];
            hashcode = 31 * hashcode + ((item == null) ? 0 : item.hashCode());
        }
        return hashcode;
    }

    /**
     * @param o the Object to find the location of the first occurrence of
     * @throws NullPointerException if no value is provided
     * @return the location of the first occurrence of the provided value or -1 if not found
     */
    @Override
    public int indexOf(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a value to find the location of the first occurrence of");
        }
        for(int i = 0; i < this.size; i++)
        {
            if(this.array[i].equals(o))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return true if this list is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return this.size == 0;
    }

    /**
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>()
        {
            private int currentIndex = 0;

            @Override
            public boolean hasNext()
            {
                return currentIndex < size;
            }

            @Override
            public E next()
            {
                if(!hasNext())
                {
                    throw new NoSuchElementException("This iterator has reached the end of this list");
                }
                E value = array[currentIndex];
                currentIndex++;
                return value;
            }

            @Override
            public void remove()
            {
                int removingIndex = currentIndex;
                if(currentIndex != 0)
                {
                    currentIndex--;
                }
                for(int i = removingIndex; i < size - 1; i++)
                {
                    array[i] = array[i + 1];
                }
                size--;
            }
        };
    }

    /**
     * @param o the Object to find the location of the last occurrence of
     * @return the location of the last occurrence of the provided value or -1 if not found
     * @throws NullPointerException if no value is provided
     */
    @Override
    public int lastIndexOf(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a value to find the last occurrence of in this ArrayList");
        }
        for(int i = this.size - 1; i >= 0; i--)
        {
            if(this.array[i].equals(o))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return a list iterator over the elements in this list
     */
    @Override
    public ListIterator<E> listIterator()
    {
        return new ListIterator<E>()
        {
            private int currentIndex = 0;

            @Override
            public boolean hasNext()
            {
                return currentIndex < size;
            }

            @Override
            public E next()
            {
                if(!hasNext())
                {
                    throw new NoSuchElementException("There are no more elements left in this list iterator");
                }
                E value = array[currentIndex];
                currentIndex++;
                return value;
            }

            @Override
            public boolean hasPrevious()
            {
                return currentIndex >= 0;
            }

            @Override
            public E previous()
            {
                if(!hasPrevious())
                {
                    throw new NoSuchElementException("There are no more elements left in this list iterator");
                }
                E value = array[currentIndex];
                currentIndex--;
                return value;
            }

            @Override
            public int nextIndex()
            {
                return currentIndex;
            }

            @Override
            public int previousIndex()
            {
                return currentIndex - 1;
            }

            @Override
            public void set(E e)
            {
                if(e == null)
                {
                    throw new NullPointerException("You MUST provide a replacement value");
                }
                array[currentIndex] = e;
            }

            @Override
            public void add(E e)
            {
                if(e == null)
                {
                    throw new NullPointerException("You MUST provide a value to add at this position");
                }
                ensureCapacity();
                for(int i = size; i > currentIndex; i--)
                {
                    array[i] = array[i - 1];
                }
                array[currentIndex] = e;
                size++;
            }

            @Override
            public void remove()
            {
                int removingIndex = currentIndex;
                if(currentIndex != 0)
                {
                    currentIndex--;
                }
                for(int i = removingIndex; i < size - 1; i++)
                {
                    array[i] = array[i + 1];
                }
                size--;
            }
        };
    }

    /**
     * @param index the location at which to start the List Iterator
     * @return a list iterator over the elements in this list starting at the provided index
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     */
    @Override
    public ListIterator<E> listIterator(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        return new ListIterator<E>()
        {
            private int currentIndex = index;

            @Override
            public boolean hasNext()
            {
                return currentIndex < size;
            }

            @Override
            public E next()
            {
                if(!hasNext())
                {
                    throw new NoSuchElementException("There are no more elements left in this list iterator");
                }
                E value = array[currentIndex];
                currentIndex++;
                return value;
            }

            @Override
            public boolean hasPrevious()
            {
                return currentIndex >= 0;
            }

            @Override
            public E previous()
            {
                if(!hasPrevious())
                {
                    throw new NoSuchElementException("There are no more elements left in this list iterator");
                }
                E value = array[currentIndex];
                currentIndex--;
                return value;
            }

            @Override
            public int nextIndex()
            {
                return currentIndex;
            }

            @Override
            public int previousIndex()
            {
                return currentIndex - 1;
            }

            @Override
            public void set(E e)
            {
                if(e == null)
                {
                    throw new NullPointerException("You MUST provide a replacement value");
                }
                array[currentIndex] = e;
            }

            @Override
            public void add(E e)
            {
                if(e == null)
                {
                    throw new NullPointerException("You MUST provide a value to add at this position");
                }
                ensureCapacity();
                for(int i = size; i > currentIndex; i--)
                {
                    array[i] = array[i - 1];
                }
                array[currentIndex] = e;
                size++;
            }

            @Override
            public void remove()
            {
                int removingIndex = currentIndex;
                if(currentIndex != 0)
                {
                    currentIndex--;
                }
                for(int i = removingIndex; i < size - 1; i++)
                {
                    array[i] = array[i + 1];
                }
                size--;
            }
        };
    }

    /**
     * @param index the location at which to remove a value
     * @return the value previously at the provided index
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @code The function removes and returns the value at the specified index in this List.
     */
    @Override
    public E remove(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        E value = this.array[index];
        for(int i = index; i < this.size - 1; i++)
        {
            this.array[i] = this.array[i + 1];
        }
        this.size--;
        return value;
    }

    /**
     * @param o the Object to find and remove the first occurrence of from this List
     * @return true if this List has been modified, false otherwise
     * @throws NullPointerException if no Object is provided
     * @code Finds and removes the first occurrence of the value provided, given that the user
     * provided it. If the item was not found, it returns false. If it WAS found and removed,
     * then the function returns true.
     */
    @Override
    public boolean remove(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a value to find the first occurrence of and remove");
        }
        int i = 0;
        while(i < this.size && !(this.array[i].equals(o)))
        {
            i++;
        }
        if(i >= this.size)
        {
            return false;
        }
        for(int j = i; j < this.size - 1; j++)
        {
            this.array[j] = this.array[j + 1];
        }
        this.size--;
        return true;
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
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a Collection of values to remove from this ArrayList");
        }
        if(c.isEmpty())
        {
            return false;
        }
        boolean modified = false;
        int i = 0;
        while(i < this.size)
        {
            if(c.contains(this.array[i]))
            {
                for(int j = i; j < this.size - 1; j++)
                {
                    this.array[j] = this.array[j + 1];
                }
                i--;
                this.size--;
                modified = true;
            }
            i++;
        }
        return modified;
    }

    /**
     * @param c Collection of values to keep if found
     * @return true if this List has been modified, false otherwise
     * @throws NullPointerException if no Collection is provided
     * @code Keeps in this list all its elements that are contained in the specified Collection
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(Collection<?> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a Collection of values to remove from this ArrayList");
        }
        if(c.isEmpty())
        {
            this.size = 0;
            this.capacity = 10;
            this.array = (E[]) new Object[this.capacity];
            return true;
        }
        boolean modified = false;
        int i = 0;
        while(i < this.size)
        {
            if(!(c.contains(this.array[i])))
            {
                for(int j = i; j < this.size - 1; j++)
                {
                    this.array[j] = this.array[j + 1];
                }
                i--;
                this.size--;
                modified = true;
            }
            i++;
        }
        return modified;
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
        if(element == null)
        {
            throw new NullPointerException("You MUST provide a replacement value");
        }
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        E value = this.array[index];
        this.array[index] = element;
        return value;
    }

    /**
     * @return the number of elements in this list
     */
    @Override
    public int size()
    {
        return this.size;
    }

    /**
     * @param fromIndex the starting location from which to create this subList
     * @param toIndex   the ending location from which to create this subList
     * @throws IndexOutOfBoundsException if either is out of bounds
     * @throws IllegalArgumentException  if fromIndex is greater than 19
     */
    public List<E> subList(int fromIndex, int toIndex)
    {
        if(fromIndex < 0 && toIndex > this.size)
        {
            throw new IndexOutOfBoundsException("Indexes " + fromIndex + " and " + toIndex + " are out of bounds");
        }
        else if(fromIndex < 0)
        {
            throw new IndexOutOfBoundsException("Index " + fromIndex + " is out of bounds");
        }
        else if(toIndex > this.size)
        {
            throw new IndexOutOfBoundsException("Index " + toIndex + " is out of bounds");
        }
        else if(fromIndex > toIndex)
        {
            throw new IllegalArgumentException("fromIndex " + fromIndex + " cannot be greater than toIndex " + toIndex);
        }
        ArrayList<E> list = new ArrayList<>();
        for(int i = fromIndex; i < toIndex; i++)
        {
            list.add(this.array[i]);
        }
        return list;
    }

    /**
     * @return an array containing all the elements in this list in proper sequence
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray()
    {
        E[] values = (E[]) new Object[this.size];
        System.arraycopy(this.array, 0, values, 0, this.size);
        return values;
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
        if(a.length < this.size)
        {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), this.size);
        }
        else
        {
            System.arraycopy(this.array, 0, a, 0, this.size);
            if(a.length > this.size)
            {
                a[this.size] = null;
            }
        }
        return a;
    }

    /**
     * @code Trims the capacity of this ArrayList instance to be the list's current size
     */
    public void trimToSize()
    {
        this.capacity = this.size;
    }

    /**
     * @return a String representation of this List
     */
    @Override
    public String toString()
    {
        StringBuilder buff = new StringBuilder();
        buff.append("[");
        for(int i = 0; i < this.size; i++)
        {
            buff.append(this.array[i]);
            if(i != this.size - 1)
            {
                buff.append(", ");
            }
        }
        buff.append("]");
        return buff.toString();
    }
}
