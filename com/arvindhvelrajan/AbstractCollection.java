package com.arvindhvelrajan;

/**
 * @author arvindhvelrajan
 * @param <E> Generic Variable for this class
 */
public abstract class AbstractCollection<E> implements Collection<E>
{
    /**
     * @code Default constructor for this class
     */
    protected AbstractCollection() {}

    @Override
    public abstract Iterator<E> iterator();

    @Override
    public abstract int size();

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o)
    {
        Iterator<E> it = iterator();
        if(o == null)
        {
            while (it.hasNext())
            {
                if(it.next() == null)
                {
                    return true;
                }
            }
        }
        else
        {
            while (it.hasNext())
            {
                if(o.equals(it.next()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object[] toArray()
    {
        Object[] result = new Object[size()];
        Iterator<E> it = iterator();
        for(int i = 0; i < result.length; i++)
        {
            if(!it.hasNext())
            {
                return java.util.Arrays.copyOf(result, i);
            }
            result[i] = it.next();
        }
        return it.hasNext() ? finishToArray(result, it) : result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a)
    {
        int size = size();
        T[] result = a.length >= size ? a : (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        Iterator<E> it = iterator();
        for(int i = 0; i < result.length; i++)
        {
            if(!it.hasNext())
            {
                if(a == result)
                {
                    result[i] = null;
                }
                else if(a.length < i)
                {
                    return java.util.Arrays.copyOf(result, i);
                }
                else
                {
                    System.arraycopy(result, 0, a, 0, i);
                    if(a.length > i)
                    {
                        a[i] = null;
                    }
                }
                return a;
            }
            result[i] = (T) it.next();
        }
        return it.hasNext() ? finishToArray(result, it) : result;
    }

    private static <T> T[] finishToArray(T[] r, Iterator<?> it)
    {
        int i = r.length;
        while (it.hasNext())
        {
            int cap = r.length;
            if(i == cap)
            {
                int newCap = cap + (cap >> 1) + 1;
                r = java.util.Arrays.copyOf(r, newCap);
            }
            r[i++] = (T) it.next();
        }
        return i == r.length ? r : java.util.Arrays.copyOf(r, i);
    }

    @Override
    public boolean add(E e)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o)
    {
        Iterator<E> it = iterator();
        if(o == null)
        {
            while (it.hasNext())
            {
                if(it.next() == null)
                {
                    it.remove();
                    return true;
                }
            }
        }
        else
        {
            while (it.hasNext())
            {
                if(o.equals(it.next()))
                {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        for(Object e : c.toArray())
        {
            if(!contains(e))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        boolean modified = false;
        for(Object e : c.toArray())
        {
            if(add((E) e))
            {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext())
        {
            if(c.contains(it.next()))
            {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext())
        {
            if(!c.contains(it.next()))
            {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear()
    {
        Iterator<E> it = iterator();
        while (it.hasNext())
        {
            it.next();
            it.remove();
        }
    }

    @Override
    public String toString()
    {
        Iterator<E> it = iterator();
        if(!it.hasNext())
        {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(;;)
        {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if(!it.hasNext())
            {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
