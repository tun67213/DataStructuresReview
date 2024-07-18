package com.arvindhvelrajan;

import java.util.NoSuchElementException;

/**
 * @author arvindhvelrajan
 * @param <E> Generic variable for this class
 */
public abstract class AbstractSequentialList<E> extends AbstractList<E>
{
    private static class Node<E>
    {
        E data;
        Node<E> next;

        Node(E value)
        {
            this.data = value;
            this.next = null;
        }
    }

    private int size;
    private Node<E> head;

    public AbstractSequentialList()
    {
        this.size = 0;
        head = null;
    }

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

    @Override
    public int size()
    {
        return this.size;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 | index > this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }

        return new ListIterator<E>() {
            private Node<E> current;
            private int currentIndex;

            {
                this.current = head;
                this.currentIndex = 0;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                    currentIndex++;
                }
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = current.data;
                current = current.next;
                currentIndex++;
                return value;
            }

            @Override
            public boolean hasPrevious() {
                throw new UnsupportedOperationException();
            }

            @Override
            public E previous() {
                throw new UnsupportedOperationException();
            }

            @Override
            public int nextIndex() {
                return currentIndex;
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException();
            }
        };
    }
}
