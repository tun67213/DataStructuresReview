package com.arvindhvelrajan;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for this class
 */
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable
{
    private static class Node<E>
    {
        private Node<E> previous;
        private E data;
        private Node<E> next;

        public Node(E value)
        {
            this.previous = null;
            this.data = value;
            this.next = null;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    /**
     * @code Default constructor to initial an empty Linked List
     */
    public LinkedList()
    {
        this.size = 0;
        head = null;
        tail = null;
    }

    /**
     * @param c Collection of values to initialize this Linked List with
     * @throws NullPointerException if no Collection is provided
     * @code Initializes this Linked List with values from the provided Collection
     */
    public LinkedList(Collection<? extends E> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a collection of values to initialize this Linked LIst with");
        }
        this.size = 0;
        head = null;
        tail = null;
        if(!c.isEmpty())
        {
            Iterator<? extends E> iterator = c.iterator();
            while(iterator.hasNext())
            {
                Node<E> newNode = new Node<>(iterator.next());
                if(head == null)
                {
                    head = newNode;
                    tail = newNode;
                }
                else
                {
                    tail.next = newNode;
                    newNode.previous = tail;
                    tail = tail.next;
                }
                this.size++;
            }
        }
    }

    /**
     * @param e the value to be added to the end of this Linked List
     * @throws NullPointerException if no value is provided
     * @return true if the value has been successfully added
     * @code Creates a Node for the provided element and links it to the
     *       end of this Linked List
     */
    @Override
    public boolean add(E e)
    {
        if(e == null)
        {
            throw new NullPointerException("You MUST provide a value to add to this Linked List");
        }
        Node<E> newNode = new Node<>(e);
        if(tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.previous = tail;
            tail = tail.next;
        }
        this.size++;
        return true;
    }

    /**
     * @param index the location at which to add the provided element
     * @param element the value to be linked to this Linked List
     * @throws NullPointerException if no value is provided
     * @throws IndexOutOfBoundsException if index is provided, but out of bounds
     */
    @Override
    public void add(int index, E element)
    {
        if(element == null)
        {
            throw new NullPointerException("You MUST provide a value to add to this Linked List");
        }
        if(index < 0 || index > this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        Node<E> newNode = new Node<>(element);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else if(index == 0)
        {
            head.previous = newNode;
            newNode.next = head;
            head = head.previous;
        }
        else if(index == this.size)
        {
            tail.next = newNode;
            newNode.previous = tail;
            tail = tail.next;
        }
        else
        {
            Node<E> current = head;
            for(int i = 0; i < index - 1; i++)
            {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.previous = current;
            current.next.previous = newNode;
            current.next = newNode;
        }
        this.size++;
    }

    /**
     * @param c the Collection of values to add to the end of this Linked List
     * @throws NullPointerException if no Collection is provided
     * @return true if the Collection is there and has values, false if the collection
     *         is empty
     * @code Adds the values in the provided collection to the end of this Linked List
     *       in the order returned by the Collection's iterator
     */
    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a collection of values to add to this Linked List");
        }
        if(c.isEmpty())
        {
            return false;
        }
        Iterator<? extends E> iterator = c.iterator();
        while(iterator.hasNext())
        {
            E value = iterator.next();
            if(value == null)
            {
                throw new NullPointerException("No null values permitted in this Linked List");
            }
            Node<E> newNode = new Node<>(value);
            if(tail == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                tail.next = newNode;
                newNode.previous = tail;
                tail = tail.next;
            }
            this.size++;
        }
        return true;
    }

    /**
     * @param index the location at which to start adding the Collection of values
     * @param c the Collection of values to add to this Linked List
     * @throws NullPointerException if no Collection is provided
     * @throws IndexOutOfBoundsException if Collection is provided, but index is out of
     *         bounds
     * @return true if there are no problems and all values are added to this Linked List
     *         false if this Collection is empty
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a collection of values to add to this Linked List");
        }
        if(index < 0 || index > this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if(c.isEmpty())
        {
            return false;
        }
        Iterator<? extends E> iterator = c.iterator();
        Node<E> newNode = null;
        boolean addedOne = false;
        Node<E> current = head;
        if(index == 0)
        {
            while(iterator.hasNext())
            {
                E value = iterator.next();
                if(value == null)
                {
                    throw new NullPointerException("No null values permitted in this Linked List");
                }
                newNode = new Node<>(value);
                if(addedOne)
                {
                    newNode.next = current.next;
                    newNode.previous = current;
                    current.next.previous = newNode;
                    current.next = newNode;
                    current = current.next;
                }
                else
                {
                    head.previous = newNode;
                    newNode.next = head;
                    head = head.previous;
                    addedOne = true;
                }
                this.size++;
            }
        }
        else if(index == this.size)
        {
            while(iterator.hasNext())
            {
                newNode = new Node<>(iterator.next());
                if(tail == null)
                {
                    head = newNode;
                    tail = newNode;
                }
                else
                {
                    tail.next = newNode;
                    newNode.previous = tail;
                    tail = tail.next;
                }
                this.size++;
            }
        }
        else
        {
            for(int i = 0; i < index - 1; i++)
            {
                current = current.next;
            }
            while(iterator.hasNext())
            {
                newNode = new Node<>(iterator.next());
                newNode.next = current.next;
                newNode.previous = current;
                current.next.previous = newNode;
                current.next = newNode;
                current = current.next;
                this.size++;
            }
        }
        return true;
    }

    /**
     * @param e the value to be added as the head of this Linked List
     * @throws NullPointerException if no value is provided
     * @code Adds the provided value as the head node
     */
    public void addFirst(E e)
    {
        if(e == null)
        {
            throw new NullPointerException("You MUST provide a value to add as the head Node to this Linked List");
        }
        Node<E> newNode = new Node<>(e);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            head.previous = newNode;
            newNode.next = head;
            head = head.previous;
        }
        this.size++;
    }

    /**
     * @param e the value to be added as the tail of this Linked List
     * @throws NullPointerException if no value is provided
     * @code Adds the provided value as the tail node
     */
    public void addLast(E e)
    {
        if(e == null)
        {
            throw new NullPointerException("You MUST provide a value to add as the tail Node to this Linked List");
        }
        Node<E> newNode = new Node<>(e);
        if(tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.previous = tail;
            tail = tail.next;
        }
        this.size++;
    }

    /**
     * @code Creates a new Linked List, erasing all the values that were existent in it
     */
    @Override
    public void clear()
    {
        this.size = 0;
        head = null;
        tail = null;
    }

    /**
     * @return a shallow copy of this Linked List Object
     */
    @Override
    public Object clone()
    {
        LinkedList<E> list = new LinkedList<>();
        for(Node<E> current = head; current != null; current = current.next)
        {
            list.add(current.data);
        }
        return list;
    }

    /**
     * @param o the Object to find the existence of in this Linked List
     * @throws NullPointerException if no Object is provided
     * @return true if the Object is found, false otherwise
     */
    @Override
    public boolean contains(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a value to find existence of in this Linked List");
        }
        Node<E> current = head;
        while(current != null && !(current.data.equals(o)))
        {
            current = current.next;
        }
        return current != null;
    }

    /**
     * @param c Collection of values to search the existence of in this List
     * @throws NullPointerException if no Collection is provided
     * @return true if the Collection has values and the values in the Collection are found in
     * this List, false otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c)
    {
        if(c == null)
        {
            throw new NullPointerException("You MUST provide a collection of values to find the existence of in this Linked List");
        }
        if(c.isEmpty())
        {
            return true;
        }
        Node<E> current = head;
        Iterator<?> iterator = c.iterator();
        while(iterator.hasNext())
        {
            Object value = iterator.next();
            while(current != null && !(current.data.equals(value)))
            {
                current = current.next;
            }
            if(current == null)
            {
                return false;
            }
            current = head;
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
        if(this == o)
        {
            return true;
        }
        if(o == null || getClass() != o.getClass())
        {
            return false;
        }
        LinkedList<?> that = (LinkedList<?>) o;
        if(this.size != that.size)
        {
            return false;
        }
        Node<E> current = head;
        Node<?> current2 = that.head;

        while(current != null && current2 != null)
        {
            if(!(current.data.equals(current2.data)))
            {
                return false;
            }
            current = current.next;
            current2 = current2.next;
        }
        return true;
    }

    /**
     * @return an Iterator that traverses from tail to head (i.e., in reverse order)
     */
    public Iterator<E> descendingIterator()
    {
        return new Iterator<E>()
        {
            private Node<E> current;
            private int currentIndex;

            {
                current = tail;
                currentIndex = size - 1;
            }

            @Override
            public boolean hasNext()
            {
                return currentIndex >= 0;
            }

            @Override
            public E next()
            {
                if(!hasNext())
                {
                    throw new NoSuchElementException("No more elements to iterate");
                }
                E value = current.data;
                current = current.previous;
                currentIndex--;
                return value;
            }

            @Override
            public void remove()
            {
                Node<E> removingNode = current;
                if(head.next == null)
                {
                    head = null;
                    tail = null;
                    current = null;
                }
                else if(currentIndex == 0)
                {
                    head = head.next;
                    removingNode.next = null;
                    head.previous = null;
                    current = head;
                }
                else if(currentIndex == size - 1)
                {
                    tail = tail.previous;
                    removingNode.previous = null;
                    tail.next = null;
                    current = tail;
                }
                else
                {
                    current = current.previous;
                    removingNode.previous.next = removingNode.next;
                    removingNode.next.previous = removingNode.previous;
                    removingNode.previous = null;
                    removingNode.next = null;
                }
                size--;
            }
        };
    }

    /**
     * @throws NoSuchElementException if this Linked List is null
     * @return the value at the head Node in this Linked List
     */
    public E element()
    {
        if(head == null)
        {
            throw new NoSuchElementException("This Linked List is empty");
        }
        return head.data;
    }

    /**
     * @param index the location at which to retrieve the value from
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @return the value at the provided index
     * @code Retrieves and returns the value in the Node at the provided index
     */
    @Override
    public E get(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current.data;
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value at the head node in this Linked List
     */
    public E getFirst()
    {
        if(head == null)
        {
            throw new NoSuchElementException("This Linked List is empty");
        }
        return head.data;
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value at the tail node in this Linked List
     */
    public E getLast()
    {
        if(tail == null)
        {
            throw new NoSuchElementException("This Linked List is empty");
        }
        return tail.data;
    }

    /**
     * @return the hash code value for this list
     */
    @Override
    public int hashCode()
    {
        int hashcode = 1;
        for(Node<E> current = head; current != null; current = current.next)
        {
            E value = current.data;
            hashcode = 31 * hashcode + ((value == null) ? 0 : value.hashCode());
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
            throw new NullPointerException("You MUST provide a value to find the location of the first occurrence of in this Linked List");
        }
        Node<E> current = head;
        for(int i = 0; i < this.size; i++)
        {
            if(current.data.equals(o))
            {
                return i;
            }
            current = current.next;
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
            private Node<E> current = head;

            @Override
            public boolean hasNext()
            {
                return current != null;
            }

            @Override
            public E next()
            {
                if(!hasNext())
                {
                    throw new NoSuchElementException("Iterator has reached the end of this Linked List");
                }
                E value = current.data;
                current = current.next;
                return value;
            }

            @Override
            public void remove()
            {
                if(current == null)
                {
                    throw new NullPointerException("This Linked List is empty");
                }
                Node<E> removingNode = current;
                if(current.previous == null && current.next == null)
                {
                    head = null;
                    tail = null;
                    current = null;
                }
                else if(current.previous == null)
                {
                    head = head.next;
                    removingNode.next = null;
                    head.previous = null;
                    current = head;
                }
                else if(current.next == null)
                {
                    tail = tail.previous;
                    removingNode.previous = null;
                    tail.next = null;
                    current = tail;
                }
                else
                {
                    removingNode.previous.next = removingNode.next;
                    removingNode.next.previous = removingNode.previous;
                    removingNode.previous = null;
                    removingNode.next = null;
                }
                size--;
            }
        };
    }

    /**
     * @param o the Object to find the location of the last occurrence of
     * @throws NullPointerException if no value is provided
     * @return the location of the last occurrence of the provided value or -1 if not found
     */
    @Override
    public int lastIndexOf(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a value to find the location of the last occurrence of");
        }
        Node<E> current = tail;
        for(int i = this.size - 1; i >= 0; i--)
        {
            if(current.data.equals(o))
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
            private int currentIndex;
            private Node<E> current;

            {
                currentIndex = 0;
                current = head;
            }

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
                    throw new NoSuchElementException("List Iterator has reached the end of this Linked List");
                }
                E value = current.data;
                current = current.next;
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
                    throw new NoSuchElementException("List Iterator has reached the beginning of this Linked LIst");
                }
                E value = current.data;
                current = current.previous;
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
            public void remove()
            {
                Node<E> removingNode = current;
                if(current.previous == null && current.next == null)
                {
                    currentIndex = -1;
                    current = null;
                    head = null;
                    tail = null;
                }
                else if(current.previous == null)
                {
                    head = head.next;
                    removingNode.next = null;
                    head.previous = null;
                    current = head;
                }
                else if(current.next == null)
                {
                    tail = tail.previous;
                    removingNode.previous = null;
                    tail.next = null;
                    current = tail;
                }
                else
                {
                    current = current.previous;
                    removingNode.previous.next = removingNode.next;
                    removingNode.next.previous = removingNode.previous;
                    removingNode.previous = null;
                    removingNode.next = null;
                }
                size--;
            }

            @Override
            public void set(E e)
            {
                if(e == null)
                {
                    throw new NullPointerException("You MUST provide a replacement value");
                }
                current.data = e;
            }

            @Override
            public void add(E e)
            {
                if(e == null)
                {
                    throw new NullPointerException("You MUST provide a value to add to this Linked List");
                }
                Node<E> newNode = new Node<>(e);
                if(head == null)
                {
                    head = newNode;
                    tail = newNode;
                    current = tail;
                }
                else if(current.next == null)
                {
                    tail.next = newNode;
                    newNode.previous = tail;
                    tail = tail.next;
                    current = tail;
                }
                else
                {
                    newNode.next = current.next;
                    newNode.previous = current;
                    current.next.previous = newNode;
                    current.next = newNode;
                    current = current.next;
                }
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
            private int currentIndex;
            private Node<E> current;

            {
                currentIndex = index;
                current = head;
            }

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
                    throw new NoSuchElementException("List Iterator has reached the end of this Linked List");
                }
                E value = current.data;
                current = current.next;
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
                    throw new NoSuchElementException("List Iterator has reached the beginning of this Linked LIst");
                }
                E value = current.data;
                current = current.previous;
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
            public void remove()
            {
                Node<E> removingNode = current;
                if(current.previous == null && current.next == null)
                {
                    currentIndex = -1;
                    current = null;
                    head = null;
                    tail = null;
                }
                else if(current.previous == null)
                {
                    head = head.next;
                    removingNode.next = null;
                    head.previous = null;
                    current = head;
                }
                else if(current.next == null)
                {
                    tail = tail.previous;
                    removingNode.previous = null;
                    tail.next = null;
                    current = tail;
                }
                else
                {
                    current = current.previous;
                    removingNode.previous.next = removingNode.next;
                    removingNode.next.previous = removingNode.previous;
                    removingNode.previous = null;
                    removingNode.next = null;
                }
                size--;
            }

            @Override
            public void set(E e)
            {
                if(e == null)
                {
                    throw new NullPointerException("You MUST provide a replacement value");
                }
                current.data = e;
            }

            @Override
            public void add(E e)
            {
                if(e == null)
                {
                    throw new NullPointerException("You MUST provide a value to add to this Linked List");
                }
                Node<E> newNode = new Node<>(e);
                if(head == null)
                {
                    head = newNode;
                    tail = newNode;
                    current = tail;
                }
                else if(current.next == null)
                {
                    tail.next = newNode;
                    newNode.previous = tail;
                    tail = tail.next;
                    current = tail;
                }
                else
                {
                    newNode.next = current.next;
                    newNode.previous = current;
                    current.next.previous = newNode;
                    current.next = newNode;
                    current = current.next;
                }
            }
        };
    }

    /**
     * @param e the value to add at the end of this Linked List
     * @throws NullPointerException if no value is provided
     * @return true if the value has been successfully added
     * @code Adds the specified element as the tail (last element) of this list
     */
    public boolean offer(E e)
    {
        if(e == null)
        {
            throw new NullPointerException("You MUST provide a value to offer to this Linked List");
        }
        Node<E> newNode = new Node<>(e);
        if(tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.previous = tail;
            tail = tail.next;
        }
        this.size++;
        return true;
    }

    /**
     * @param e the value to add at the beginning of this Linked List
     * @throws NullPointerException if no value is provided
     * @return true if no exceptions are thrown and the value is successfully added
     * @code Adds the specified value at the beginning of this LinkedList
     */
    public boolean offerFirst(E e)
    {
        if(e == null)
        {
            throw new NullPointerException("You MUST provide a value to offer to the front of this Linked List");
        }
        Node<E> newNode = new Node<>(e);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            head.previous = newNode;
            newNode.next = head;
            head = head.previous;
        }
        this.size++;
        return true;
    }

    /**
     * @param e the value to add at the end of this Linked List
     * @throws NullPointerException if no value is provided
     * @return true if no exceptions are thrown and the value is successfully added
     * @code Adds the specified value at the end of this Linked List
     */
    public boolean offerLast(E e)
    {
        if(e == null)
        {
            throw new NullPointerException("You MUST provide a value to offer to this Linked List");
        }
        Node<E> newNode = new Node<>(e);
        if(tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.previous = tail;
            tail = tail.next;
        }
        this.size++;
        return true;
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value in the head node of this Linked List
     */
    public E peek()
    {
        if(head == null)
        {
            throw new NullPointerException("This Linked List is empty");
        }
        return head.data;
    }

    /**
     * @return the value in the head node of this Linked List or null if this list is empty
     */
    public E peekFirst()
    {
        if(head == null)
        {
            return null;
        }
        return head.data;
    }

    /**
     * @return the value in the tail node of this Linked List or null if this list is empty
     */
    public E peekLast()
    {
        if(tail == null)
        {
            return null;
        }
        return tail.data;
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value that was previously in the Node at head
     * @code Removes the Node at head, reassigning it to the next Node if existent. If
     *       the Node to be removed is the only Node, sets both head and tail to null
     *       with the size being reset to 0. If not, then the head pointer is moved to
     *       the Node pointed to by next in the previous head Node.
     */
    public E poll()
    {
        if(head == null)
        {
            throw new NoSuchElementException("This Linked List is empty");
        }
        Node<E> removingNode = head;
        if(head.next == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            removingNode.next = null;
            head.previous = null;
        }
        this.size--;
        return removingNode.data;
    }

    /**
     * @return the value that was previously in the Node at head or null if this Linked
     *         List is empty
     * @code Removes the Node at head, reassigning it to the next Node if existent. If
     *       the Node to be removed is the only Node, sets both head and tail to null
     *       with the size being reset to 0. If not, then the head pointer is moved to
     *       the Node pointed to by next in the previous head Node.
     */
    public E pollFirst()
    {
        if(head == null)
        {
            return null;
        }
        Node<E> removingNode = head;
        if(head.next == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            removingNode.next = null;
            head.previous = null;
        }
        this.size--;
        return removingNode.data;
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the value that was previously in the Node at tail
     * @code Removes the Node at tail, reassigning it to the previous Node if existent. If
     *       the Node to be removed is the only Node, sets both head and tail to null
     *       with the size being reset to 0. If not, then the tail pointer is moved to
     *       the Node pointed to by previous in the previous tail Node.
     */
    public E pollLast()
    {
        if(tail == null)
        {
            return null;
        }
        Node<E> removingNode = tail;
        if(tail.previous == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail = tail.previous;
            removingNode.previous = null;
            tail.next = null;
        }
        this.size++;
        return removingNode.data;
    }

    /**
     * @throws EmptyStackException if the stack representing this Linked List is empty
     * @return the value previously at head in this Linked List
     * @code Pops an element from the stack represented by this list
     */
    public E pop()
    {
        if(head == null)
        {
            throw new EmptyStackException();
        }
        Node<E> removingNode = head;
        if(head.next == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            removingNode.next = null;
            head.previous = null;
        }
        this.size++;
        return removingNode.data;
    }

    /**
     * @param e the value to push onto the stack represented by this list
     * @throws NullPointerException if no value is provided
     * @code Adds the provided value to the top of the stack represented by this list
     */
    public void push(E e)
    {
        if(e == null)
        {
            throw new NullPointerException("You MUST provide a value to push onto the stack representing this Linked List");
        }
        Node<E> newNode = new Node<>(e);
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            head.previous = newNode;
            newNode.next = head;
            head = head.previous;
        }
        this.size++;
    }

    /**
     * @return the value in the Node previous pointed to by head
     * @throws NoSuchElementException if this Linked List is empty
     * @code Removes the Node pointed to by head. If it is the only value, reassigns
     *       head to null and tail to null. If not, reassigns it to the next value in
     *       this Linked List.
     */
    public E remove()
    {
        if(head == null)
        {
            throw new NoSuchElementException("This Linked List is empty");
        }
        Node<E> removingNode = head;
        if(head.next == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            removingNode.next = null;
            head.previous = null;
        }
        this.size--;
        return removingNode.data;
    }

    /**
     * @param index the location at which to remove a Node
     * @throws IndexOutOfBoundsException if index is provided, but is out of bounds
     * @return the value previously at the provided index
     * @code Removes and returns the value in the Node at the specified index.
     */
    @Override
    public E remove(int index)
    {
        if(index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        Node<E> removingNode = head;
        if(head.next == null)
        {
            head = null;
            tail = null;
        }
        else if(index == 0)
        {
            head = head.next;
            removingNode.next = null;
            head.previous = null;
        }
        else if(index == this.size - 1)
        {
            removingNode = tail;
            tail = tail.previous;
            removingNode.previous = null;
            tail.next = null;
        }
        else
        {
            for(int i = 0; i < index; i++)
            {
                removingNode = removingNode.next;
            }
            removingNode.previous.next = removingNode.next;
            removingNode.next.previous = removingNode.previous;
            removingNode.previous = null;
            removingNode.next = null;
        }
        this.size--;
        return removingNode.data;
    }

    /**
     * @param o the Object to find and remove the first occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if this Linked List has been modified, false otherwise
     * @code Removes the first occurrence of the specified Object in this List
     */
    @Override
    public boolean remove(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a value to find and remove the first occurrence of");
        }
        Node<E> removingNode = head;
        while(removingNode != null && !(removingNode.data.equals(o)))
        {
            removingNode = removingNode.next;
        }
        if(removingNode == null)
        {
            return false;
        }
        else if(removingNode.previous == null && removingNode.next == null)
        {
            head = null;
            tail = null;
        }
        else if(removingNode.previous == null)
        {
            head = head.next;
            removingNode.next = null;
            head.previous = null;
        }
        else if(removingNode.next == null)
        {
            tail = tail.previous;
            removingNode.previous = null;
            tail.next = null;
        }
        else
        {
            removingNode.previous.next = removingNode.next;
            removingNode.next.previous = removingNode.previous;
            removingNode.previous = null;
            removingNode.next = null;
        }
        this.size--;
        return true;
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the first element from this list
     * @code Removes and returns the first element from this list
     */
    public E removeFirst()
    {
        if(head == null)
        {
            throw new NoSuchElementException("This Linked List is empty");
        }
        Node<E> removingNode = head;
        if(head.next == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            head = head.next;
            removingNode.next = null;
            head.previous = null;
        }
        this.size--;
        return removingNode.data;
    }

    /**
     * @param o the Object to find and remove the first occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if this Linked List has been modified, false otherwise
     * @code Removes the first occurrence of the provided Object if found, false if
     *       not found
     */
    public boolean removeFirstOccurrence(Object o)
    {
        if(o == null)
        {
            throw new NullPointerException("You MUST provide a value to find and remove the first occurrence of");
        }
        Node<E> removingNode = head;
        while(removingNode != null && !(removingNode.data.equals(o)))
        {
            removingNode = removingNode.next;
        }
        if(removingNode == null)
        {
            return false;
        }
        else if(removingNode.previous == null && removingNode.next == null)
        {
            head = null;
            tail = null;
        }
        else if(removingNode.previous == null)
        {
            head = head.next;
            removingNode.next = null;
            head.previous = null;
        }
        else if(removingNode.next == null)
        {
            tail = tail.previous;
            removingNode.previous = null;
            tail.next = null;
        }
        else
        {
            removingNode.previous.next = removingNode.next;
            removingNode.next.previous = removingNode.previous;
            removingNode.previous = null;
            removingNode.next = null;
        }
        this.size--;
        return true;
    }

    /**
     * @throws NoSuchElementException if this Linked List is empty
     * @return the last element from this list
     * @code Removes and returns the last element from this list
     */
    public E removeLast()
    {
        if(tail == null)
        {
            throw new NoSuchElementException("This Linked List is empty");
        }
        Node<E> removingNode = tail;
        if(tail.previous == null)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail = tail.previous;
            removingNode.previous = null;
            tail.next = null;
        }
        this.size--;
        return removingNode.data;
    }

    /**
     * @param o the Object to find and remove the last occurrence of
     * @throws NullPointerException if no Object is provided
     * @return true if this Linked List has been modified, false otherwise
     * @code Removes the last occurrence of the provided Object if found, false if
     *       not found
     */
    public boolean removeLastOccurrence(Object o)
    {
        throw new UnsupportedOperationException("Not yet implemented");
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
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param c Collection of values to keep if found
     * @return true if this List has been modified, false otherwise
     * @throws NullPointerException if no Collection is provided
     * @code Keeps in this list all its elements that are contained in the specified Collection
     */
    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not yet implemented");
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
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the number of elements in this list
     */
    @Override
    public int size()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @param fromIndex the starting location from which to create this subList
     * @param toIndex   the ending location from which to create this subList
     * @throws IndexOutOfBoundsException if either is out of bounds
     * @throws IllegalArgumentException  if fromIndex is greater than 19
     */
    public List<E> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return an array containing all the elements in this list in proper sequence
     */
    @Override
    public Object[] toArray()
    {
        throw new UnsupportedOperationException("Not yet implemented");
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
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return a readable String representation of this Linked List
     */
    @Override
    public String toString()
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
