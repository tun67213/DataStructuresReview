# DataStructuresReview
 
## Project Description
    
    This Project is designed to demonstrate a few of the various data structures that exist in Java 
    through implementing them. Those include ArrayList and LinkedList. For the LinkedList 
    class, the implementation that will be followed is the DoublyLinkedList class as per 
    what is followed in standard Java.

## Files

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
    If the user did not provide a value, i.e. just wrote 'list.contains();', then the function will throw a NullPointerException.
    If the user provides an item, the list will search for it index by index.
        If found, it will return true immediately.
        If it has iterated through the whole list, it means that the value does not exist in this Collection, returning false. 