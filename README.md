# DataStructuresReview
 
## Project Description
    
    This Project is designed to demonstrate a few of the various data structures that exist in Java 
    through implementing them. Those include ArrayList and LinkedList. For the LinkedList 
    class, the implementation that will be followed is the DoublyLinkedList class as per 
    what is followed in Java SE 7.

## Files and Functionalities

### AbstractCollection.java, AbstractList.java, AbstractSequentialList.java

    These are three files that extend each other, i.e., AbstractList<E> extends AbstractCollection<E> and AbstractSequentialList<E> extends AbstractList<E>.
    These files use generic variable types so that they can accommodate any and all Data Structures that the user desires to use. They are all abstract classes.


### Cloneable.java, Serializable.java, RandomAccess.java

    These are three empty interfaces that exist for if another user would like to add additional functionalities to this project.


### Iterator.java

This interface builds the structure for the Iterator interface by introducing the three following functions:
#### boolean hasNext():
    Checks if the Iterator has more values to present to the user. 
    Returns true if so, false otherwise.
#### E next():
    Uses hasNext() to see if there are more values to return. 
        If so...
            Saves the value at the current pointer,
            Moves the pointer to the next location,
            Finally returns the value that was at that previous place
        If not...
            Simply throws an error.
#### void remove():
    If the pointer is still pointing to some value, removes that value.
    The function returns nothing since it has a void return type


### Iterable.java

This interface simply uses the Iterator.java interface we created above.
With that, it has the following function with a generic variable T:
#### Iterator<T> iterator()
    Creates and returns an iterator over a set of elements of type T


### Collection.java

This is another interface that is an extension of the Iterable interface that we created previously.
It features most of the functions that are necessary to construct our List interface later on.
Those functions are as follows:
#### boolean add(E e)
    This function takes a few steps as follows:
        1. Examines the provided element to see if a value is actually existent or if the user provided a variable with no value (i.e. e is null)
        2. If e is null, then throw an exception and terminate the code immediately.
        3. If not, then add the provided node to the end of this Collection
#### boolean addAll(Collection<? extends E> c)
    This function, similar to add(E e), also takes a few steps like this:
        1. Checks if a collection variable has been provided
        2. If not (i.e. c == null), then throws a NullPointerException indicating that this is not permitted
        3. If yes, then adds the values to the end of this Collection in the order that it is presented in
#### void clear()
    This function creates an empty list, resetting everything to the way it was initially created when the user called the constructor.
#### boolean contains(Object o)
    If the user does not provide a value, i.e. just wrote 'list.contains();', then the function should throw a NullPointerException.
    If the user provides an item, the list will search for it index by index.
        If found, it will return true immediately.
        If it has iterated through the whole list, it means that the value does not exist in this Collection, returning false. 
#### boolean containsAll(Collection<?> c)
    If the user does not provide a Collection of values, then the function throws an exception.
    If the user provides a Collection, then using the Collection's iterator() function, the program iterates through all the values and checks for existence in this Collection. If one is not found, immediately returns false. If all are found, i.e. the iterator has reached the end, return true.
#### boolean equals(Object o)
    If the user does not provide an Object to compare with, the function throws an exception.
    If the user provides an Object, then it checks if the object is of the same type as the Collection that is using it.
        If not, then the function throws an error.
        If so, then it checks if the Collections are the same
#### int hashCode()
    An overriden function that returns a hash code value for this collection based on the elements in this Collection
#### boolean isEmpty()
    Returns true if this Collection is empty, false otherwise
#### Iterator<E> iterator()
    Returns a Iterator of type E that runs through all the values in this Collection
#### boolean remove(Object o)
    If the user fails to provide an Object, throws an exception.
    If the user provides an Object but is not found in this Collection, returns false.
    If the user provides an Object existent in this Collection, finds and removes the first occurrence of the provided Object.
#### boolean removeAll(Collection<?> c)
    If the user fails to provide a Collection, throws an exception.
    If the user provides a Collection with no values in it, returns false.
    If any value in the provided collection exists in this Collection, removes the value from this Collection.
    If any change was made to this Collection (i.e. at least one value was removed), then the function returns true. If no changes were made, the function returns false.
#### boolean retainAll(Collection<?> c)
    Similar to removeAll(), if the user fails to provide a Collection, throws an exception.
    If the user provides a Collection with no values in it, clears the Collection of all values and returns true.
    If this Collection contains any values NOT in the provided Collection, removes it from this Collection.
    Same as above, returns true if any change was made to this Collection, false otherwise.
#### int size()
    Returns the number of values in this Collection
#### Object[] toArray()
    Returns an array that is of the same size as this Collection that contains all the values in this Collection
#### <T> T[] toArray(T[] a)
    Using a generic variable T, it creates an array that is of the same runtime as the variable T that is provided by modifying the array a such that it fits all the values in this Collection at the time it is called.


### Queue.java

This interface showcases the functions that are necessary based on documentation online.

The following are the functions:
#### boolean add(E e)
    If no value is providedthen throws NullPointerException.
    If a value is provided, adds the provided value to the queue.

#### boolean offer(E e)
    Offers the provided value to the beginning of this Queue

#### E peek()
    Retrieves and returns, but does not remove, the first value in this Queue, unless the Queue is empty

#### E poll()
    Retrieves, removes, and returns the first value, removing it from this Queue, unless the Queue is empty

#### E element()
    Similar to peek(), retrieves, but does not remove, the head of this Queue, unless the Queue is empty

#### E remove()
    Just like poll(), retrieves, removes, and returns the head of this Queue, unless the Queue is empty


### Deque.java

This interface showcases the functions that are necessary based on online documentation.

The following are the functions:
#### boolean add(E e)
    Throws an exception if no value is provided. If no exception is thrown, adds the provided value to the deque chain. Returns true after successfully adding the provided value
#### void addFirst(E e)
    If no value is provided, throws a NullPointerException(). If no exception is thrown, adds the provided value to the beginning of the deque, just as the function name suggests.
#### void addLast(E e)
    If no value is provided, throws a NullPointerException(). If no exception is thrown, adds the provided value to the end of the deque, as the function name suggests.
#### boolean contains(Object o)
    If no Object is provided, throws a NullPointerException(). If no exception is throws, looks through this deque to check for the existence of this Object. If found, returns true immediately. If it has reached the end of the iteration, it means the value was not found, returning false.
#### Iterator<E> descendingIterator()
    Returns a descending iterator starting at the end of the Deque all the way to the beginning that is of type E.
#### E element()
    Returns the head (first) value in this Deque. If no value is there, throws NoSuchElementException(). If not, simply returns the value there.
#### E getFirst()
    Retrieves, but does not remove, the first value in this Deque.
#### E getLast()
    Retrieves, but does not remove, the last value in this Deque.
#### Iterator<E> iterator()
    Returns an iterator of the values in this Deque from start to finish.
#### boolean offer(E e)
    If no element is provided, throws a NullPointerException().
    If a value IS provided, adds the provided value to the end of this Deque and returns true.
#### boolean offerFirst(E e)
    If no element is provided, throws a NullPointerException().
    If a value IS provided, adds the provided value to the beginning of this Deque and returns true.
#### boolean offerLast(E e)
    If no element is provided, throws a NullPointerException().
    If a value IS provided, adds the provided value to the end of this Deque and returns true.

