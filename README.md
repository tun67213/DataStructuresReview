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
    Returns an Iterator of type E that runs through all the values in this Collection
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
    Throws an exception if no value is provided. If no exception is thrown, adds the provided value to the deque chain. Returns true after successfully adding the provided value.
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
#### E peek()
    If the Deque is empty, throws an exception.
    If not, return the first value in this Deque.
#### E peekFirst()
    If the Deque is empty, return null.
    If not, return the first value in this Deque.
#### E peekLast()
    If the Deque is empty, return null.
    If not, return the last value in this Deque.
#### E poll()
    If the Deque is empty, throws an exception.
    If not, removes and return the first value in this Deque.
#### E pollFirst()
    If the Deque is empty, return null.
    If not, removes and return the first value in this Deque.
#### E pollLast()
    If the Deque is empty, return null.
    If not, removes and return the last value in this Deque.
#### E pop()
    If this stack is empty, throws an exception.
    If not, removes the first value from the stack representing this Deque and return it.
#### void push(E e)
    If no value is provided, throws an exception.
    If a value is provided, pushes it to the top of the stack (i.e., as the first element in this Deque).
#### E remove()
    If this stack is empty, throws an exception.
    If not, removes the first value from this Deque and return it.
#### boolean remove(Object o)
    If no value is provided, throws an exception.
    If a value is provided but is not found in this Deque, then return false.
    If it IS found and removed, then return true.
#### E removeFirst()
    Throws an exception if no value is existent in this Deque.
    Removes and return the first value returned by this Deque.
#### boolean removeFirstOccurrence(Object o)
    If no value is provided, throws an exception.
    If a value is provided but is not found in this Deque, then return false.
    If the first occurrence of the provided value IS found and removed, then return true.
    This function has the same implementation as remove()
#### E removeLast()
    Throws an exception if no value is existent in this Deque.
    Removes and return the last value returned by this Deque.
#### boolean removeLastOccurrence(Object o)
    If no value is provided, throws an exception.
    If a value is provided but is not found in this Deque, then return false.
    If the last occurrence of the provided value IS found and removed, then return true.
#### int size()
    Returns the number of elements currently in this Deque


### ListIterator.java

This interface creates a new Data Structure called the List Iterator to be used by the List interface that is an extension of the already existent Iterator interface.

It has the following function declarations:
#### void add(E e)
    If no value is provided, throws a NullPointerException.
    Inserts the specified element into this List.
#### boolean hasNext()
    Returns true if this List Iterator has more elements to present when traversing in the forward direction
#### boolean hasPrevious()
    Returns true if this List Iterator has more elements to present when traversing in the backwards direction
#### E next()
    Returns the current element in the list, and moves the pointer to the next element
#### int nextIndex()
    Returns the location at which the element returned by the subsequent call to next() is positioned at
#### E previous()
    Returns the current element in the list, and moves the pointer to the previous element
#### int previousIndex()
    Returns the location at which the element returned by the subsequent call to previous() is positioned at
#### void remove()
    Removes the element pointed to by this ListIterator, moving it to the previous pointer, or next pointer if the value to be removed is the first value in this ListIterator
#### void set(E e)
    Throws a NullPointerException if no value is provide.
    If a value IS provided, changes the value pointed to by the current index to the value mentioned in this function.


### List.java

This interface is the basis for my ArrayList and LinkedList classes.

They feature the following functions:
#### boolean add(E e)
    If no value is provided, the function throws a NullPointerException(), mentioning that a value MUST be provided.
    If a value IS provided, accommodates that value to the end of this List.
#### void add(int index, E element)
    Similar to above, if no value is provided, the function throws a NullPointerException.
    If an index is provided, but is out of bounds, throws an exception for that too.
    If both are ok, then accommodates the specified element at the specified index.
#### boolean addAll(Collection<? extends E> c)
    If no Collection is provided, the function throws a NullPointerException(), mentioning that a Collection of values MUST be provided.
    If a Collection IS provided, but has NO values in them, the function returns false, meaning no changes were made to this List.
    If all is provided, then the function accommodates and adds the value to the end of this List using the Collection's Iterator and returns true.
#### boolean addAll(int index, Collection<? extends E> c)
    If no Collection is provided, the function throws a NullPointerException(), mentioning that a Collection of values MUST be provided.
    If an index and a Collection are provided, but the index is out of bounds, throws an IndexOutOfBoundsException(), mentioning that the provided index is out of bounds.
    If both are ok, using the Collection's Iterator, inserts the values of the specified Collection starting at the specified index.
#### void clear()
    Clears the List, resetting it to defaults so that no values are existent in it.
#### boolean contains(Object o)
    Throws a NullPointerException() if no value is provided.
    If a value IS provided, it searches the List for its existence.
    If found, returns true immediately. Else, it iterates through the whole list, and if still not found, and then returns false.
#### boolean containsAll(Collection<?> c)
    Throws a NullPointerException() if no collection is provided.
    If a collection IS provided:
        If either of these conditions happen, the function will return true:
            The provided Collection contains NO values
            OR
            The values in the provided Collection are found in this List
#### boolean equals(Object o)
    Throws a NullPointerException() if no Object is provided.
    If the provided Object is the same as the Object created by the provided class, then returns true. Or else, returns false.
#### E get(int index)
    Throws an IndexOutOfBoundsException() if index is provided, but is out of bounds.
    Returns the value located at the specified index.
#### int hashCode()
    Returns the hash code value for this List.
#### int indexOf(Object o)
    Throws a NullPointerException if no Object is provided.
    If no exception is thrown, returns the location of the first occurrence of the specified item.
#### boolean isEmpty()
    Returns true if this List is empty, false otherwise.
#### Iterator<E> Iterator()
    Returns an iterator over the elements in this List in proper sequence.
#### int lastIndexOf(Object o)
    Throws a NullPointerException if no Object is provided.
    If no exception is thrown, returns the location of the last occurrence of the specified item.
#### ListIterator<E> listIterator()
    Returns a List Iterator over the elements in this List.
#### ListIterator<E> listIterator(int index)
    Throws an IndexOutOfBoundsException() if index is provided, but is out of bounds.
    If index is in bound, returns a List Iterator over the elements in this List, starting at the specified index.
#### E remove(int index)
    Throws an IndexOutOfBoundsException() if index is provided, but is out of bounds.
    If index is in bound...
        First the program saves the value at the specified index.
        Then, it removes the value from this List by shifting everything after it one step forward.
#### boolean remove(Object o)
    Throws a NullPointerException() if no value is provided.
    Searches for the first occurrence of the provided Object.
    If the Object is not found, returns false.
    If the Object IS found, then removes the Object from this List and returns true.
#### boolean removeAll(Collection<?> c)
    Throws a NullPointerException() if no Collection is provided.
    If the Collection is empty, return false.
    If any values in the Collection are found in this List, removes it from this List.
    In the end, it returns true if this list has been modified, false otherwise.
#### boolean retainAll(Collection<?> c)
    Throws a NullPointerException() if no Collection is provided.
    Unlike removeAll(), if the Collection is empty, clears all values in this List and resets it to defaults, returning true.
    Otherwise, only keeps values that are contained in the provided Collection.
    Finally, it returns true if at least one value was removed, modifying the List.
#### E set(int index, E element)
    Throws a NullPointerException() if no replacement value is provided.
    Throws an IndexOutOfBoundsException() if index is provided, but is out of bounds.
    If no exceptions are thrown, navigates the the specified index and replaces the existing value with the provided value, returning the old value back to the user.
#### int size()
    Returns the current size of this List.
#### List<E> subList(int fromIndex, int toIndex)
    Throws an IndexOutOfBoundsException() if both or either of the provided indexes is out of bounds.
    Throws an IllegalArgumentException() if fromIndex is greater than toIndex.
    If no Exceptions are thrown, returns a List containing only the values within the specified index.
#### Object[] toArray()
    Returns an array containing all the elements in this List in proper sequence
#### <T> T[] toArray(T[] a)
    Throws a NullPointerException if no array a is provided.
    Returns an array containing all the elements in this list in proper sequence where the runtime of the returned array is the same as that of the provided array.
#### String toString()
    Returns a String representation of this List so that it is readable to the user on the command line.


### ArrayList.java
This class is the implementation for the ArrayList data structure using generics, i.e., it accommodates any data type.

#### Private Variables

##### private int size
    Keeps track of the number of elements currently in this ArrayList.
##### private int capacity
    Keeps track of the maximum number of elements the array representing this ArrayList can hold.
##### private E[] array
    An array that holds all the elements added to this ArrayList.


#### Constructors

##### public ArrayList()
    Creates an empty ArrayList.
    Initializes the size to 0, the capacity to 10, and then creates an array with the "capacity" number of values to accommodate.
##### public ArrayList(Collection<? extends E> c)
    Throws a NullPointerException() if no Collection is provided.
    Initializes the size to 0 and the capacity to 10, just like the default constructor.
    Then, if the provided Collection is NOT empty, then reassigns size to be the number of values in the Collection and capacity to be 1.5 times that.
##### public ArrayList(int initialCapacity)
    Initializes the capacity with the provided initial capacity, keeping the size the same, and using this capacity to create a new array with a bigger size allocation.


#### Functions

##### private void ensureCapacity()
    Checks if the number of elements currently in this array fill up the array, and if so, creates a new array, allocating half the amount more space in the array
##### public boolean add(E e)
    If no element e is provided, throws a NullPointerException() with an error message stating that an element is required.
    If an element is provided, uses the ensureCapacity() function above to make sure that enough space is there in the array, and then adds it to the end of a list of values already in this array, if any.
    At the end, it increments the size of this ArrayList by 1.
##### public void add(int index, E element)
    If no element is provided, throws a NullPointerException() with an error message stating that an element is required.
    If an element is provided, but index is out of bounds, throws an IndexOutOfBoundsException() with an error message stating that the provided index was out of bounds, including the index in the error message.
    If both were provided and had no problems, ensuring that there is enough space, gives space for the element to go into the specified index and places it there.
    At the end, it increments the size of this ArrayList by 1.
##### public boolean addAll(Collection<? extends E> c)
    If no Collection is provided, throws a NullPointerException() with an error message stating that a Collection is required.
    If a Collection IS provided, but there are no values in the Collection, returns false immediately.
    If the Collection contains values, then for EACH element added, uses the private ensureCapacity() function above to make sure there is enough space for the element to go in.
    For each value added, increment the size by 1.
    Finally, since all is complete, return true.
#### public boolean addAll(int index, Collection<? extends E> c)
    If no Collection is provided, throws a NullPointerException() with an error message stating that a Collection is required.
    If an index IS provided, but is out of bounds, throws an IndexOutOfBoundsException() with an error message stating that the provided index is out of bounds, INCLUDING the provided index.
    If all is valid, then, as a first step, converts the provided Collection into an array using the toArray() method in c.
    Afterwards, the program navigates to the END of the array representing this ArrayList, and, with each call to ensureCapacity(), moves the values one position to the right, ensuring a secure spot for the value to be added in this ArrayList.
#### public void clear()
    Simply empties this ArrayList, resetting it to be similar to when the user calls the default constructor 
        (i.e. List<E> list = new ArrayList<E>();)
#### public Object clone()
    Creates a shallow clone of this ArrayList object.
#### public boolean contains(Object o)
    For starters, if no Object is provided by the user, throws a NullPointerException().
    If the user DOES provide an Object, searches for it.
    If found, immediately returns true.
    Until then, iterates through the rest of this list.
    If iteration finishes, then the provided Object was not found, so the program returns false.
#### public boolean containsAll(Collection<?> c)
    If no Collection is provided, throws a NullPointerException().
    If a Collection IS provided, but is empty, returns true.
    If one of the values in the Collection is not found in this ArrayList object, returns false immediately.
    If it iterates through the whole thing with no problems, returns true.
#### public boolean equals(Object o)
    If no Object is provided, throws a NullPointerException().
    If an Object IS provided, check if the Object provided is similar to or maybe even the same as the current ArrayList.
    If so, return true. Or else, return false.
#### public E get(int index)
    If an index is provided, but is out of bounds (i.e. It is less than 0 or greater than or equal to this ArrayList's current size), then the function throws an IndexOutOfBoundsException().
    If all is fine, then returns the value at the specified index in this array.
#### public int hashCode()
    Simply returns a hash code value for this ArrayList
#### public int indexOf(Object o)
    If no Object is provided, it throws a NullPointerException().
    If an Object IS provided, then it finds the location of the FIRST occurrence of that Object.
    If found, returns that location. Else, it returns -1.
#### public boolean isEmpty()
    Returns true if this ArrayList is empty, false otherwise
#### public Iterator<E> iterator()
    Returns an iterator that runs through the values in this ArrayList using the following variables and functions:
        Variables:
            private int currentIndex
                Keeps track of the index it will iterate next
        Functions:
            public boolean hasNext()
                This function checks if there is a value that can still be returned by a subsequent call to next()
            public E next()
                If hasNext() returns false, throws an exception stating that the Iterator has reached the end of this ArrayList.
                If not, then it saves the value at the specified index, increments the index, then returns that saved value.
            public void remove()
                If the current index is not out of bounds, then it will remove the value at the specified index from this ArrayList.
#### public int lastIndexOf(Object o)
    If no value is provided, it will throw a NullPointerException().
    If an Object IS provided, then it finds the location of the LAST occurrence of that Object.
    If found, returns that location. Else, it returns -1.
#### public ListIterator<E> listIterator()
    Variables:
        private int currentIndex
            Keeps track of the index it will iterate next
    Functions:
        public boolean hasNext()
            This function checks if the List Iterator has more values to present with reference to the currentIndex variable when traversing in the forwards direction.
        public E next()
            This function calls hasNext(), and if hasNext() returns false, then it throws NoSuchElementException().
            If hasNext() is true, then it saves the value at the provided index, moves the index pointer forward, and then returns the saved value.
        public boolean hasPrevious()
            This function checks if the List Iterator has more values to present with reference to the currentIndex variable when traversing in the backwards direction.
        public E previous()
            This function calls hasPrevious(), and if hasPrevious() returns false, then it throws a NoSuchElementException().
            If hasPrevious() is true, then it saves the value at the provided index, moves the index pointer backwards, and then returns the saved value.
        public int nextIndex()
            Returns the location at which to retrieve the value on the subsequent call to next().
        public int previousIndex()
            Returns the location at which to retrieve the value on the subsequent call to previous().
        public void set(E e)
            Throws a NullPointerException() if no value is provided.
            If a value IS provided, then replaces the old value at the provided index with this new one.
        public void add(E e)
            Throws a NullPointerException() if no value is provided.
            If a value IS provided, adds the provided value into this ArrayList at the specified index by shifting all values one space to the right and then inserting it into the specified array. Then, it increments the size of this ArrayList.
        public void remove()
            Removes the value at the current index in this array and adjusts the current index accordingly.
#### public ListIterator<E> listIterator(int index)
    Variables:
        int index:
            This is the parameter to be provided by the user as to what location to start the iteration from.
            If the provided index is out of bounds, throws an IndexOutOfBoundsException().
        private int currentIndex
            Keeps track of the index it will iterate next
    Throws:
        IndexOutOfBoundsException() if the provided index is not in bound.
    Functions:
        public boolean hasNext()
            This function checks if the List Iterator has more values to present with reference to the currentIndex variable when traversing in the forwards direction.
        public E next()
            This function calls hasNext(), and if hasNext() returns false, then it throws NoSuchElementException().
            If hasNext() is true, then it saves the value at the provided index, moves the index pointer forward, and then returns the saved value.
        public boolean hasPrevious()
            This function checks if the List Iterator has more values to present with reference to the currentIndex variable when traversing in the backwards direction.
        public E previous()
            This function calls hasPrevious(), and if hasPrevious() returns false, then it throws a NoSuchElementException().
            If hasPrevious() is true, then it saves the value at the provided index, moves the index pointer backwards, and then returns the saved value.
        public int nextIndex()
            Returns the location at which to retrieve the value on the subsequent call to next().
        public int previousIndex()
            Returns the location at which to retrieve the value on the subsequent call to previous().
        public void set(E e)
            Throws a NullPointerException() if no value is provided.
            If a value IS provided, then replaces the old value at the provided index with this new one.
        public void add(E e)
            Throws a NullPointerException() if no value is provided.
            If a value IS provided, adds the provided value into this ArrayList at the specified index by shifting all values one space to the right and then inserting it into the specified array. Then, it increments the size of this ArrayList.
        public void remove()
            Removes the value at the current index in this array and adjusts the current index accordingly.
#### public E remove(int index)
    Variables:
        int index:
            This indicates the location at which to remove the value from this ArrayList.
    Throws:
        IndexOutOfBoundsException() if the provided index is out of bounds.
    Functionality:
        This function removes the value at the provided index by shifting the values that follow one index forward,
#### public boolean remove(Object o)
    Variables:
        Object o:
            This is the object to find and remove the first occurrence of.
    Throws:
        NullPointerException() if no Object is provided.
    Functionality:
        If a value IS provided, it searches for the first occurrence of it. 
            If the value is NOT found, then it returns false, indicating that no changes were made to this ArrayList.
            If the value IS found, then it shifts all the elements after that location one space to the left, overriding that value to be removed, which in turn gets removed, returning true.
#### public boolean removeAll(Collection<?> c)
    Variables:
        Collection<?> c:
            The Collection of values of unknown type to be removed if found in this ArrayList.
    Throws:
        NullPointerException() if no Collection of values is provided
    Functionality:
        If a Collection of values is not provided, then the function throws a NullPointerException().
        If a Collection IS provided, but has no values in it, the function returns false.
        If a value from this Collection has been found, the value will be removed from the array representing this ArrayList
        If the ArrayList is changed in any way, such that a value in the provided Collection has been found in this ArrayList, then the function returns true. Otherwise, the function returns false.
#### public boolean retainAll(Collection<?> c)
    Variables:
        Collection<?> c:
            The Collection of values of unknown type to be kept if found in this ArrayList.
    Throws:
        NullPointerException() if no Collection of values is provided
    Functionality:
        If a Collection of values is not provided, then the function throws a NullPointerException().
        If a Collection IS provided, but has no values in it, the function clears this ArrayList by resetting it to default and returns true.
        If a value in the array representing this ArrayList is NOT found this Collection, it is removed from the array, by which the user will not see it in when printing this ArrayList.
#### public E set(int index, E element)
    Variables:
        int index:
            The location at which to replace the existing value
        E element:
            The value to replace the existing value with
    Throws:
        NullPointerException() if no replacement value is provided
        IndexOutOfBoundsException() if an index is provided, but is less than 0 or greater than or equal to the current size of this ArrayList
    Functionality:
        If no replacement value is provided, the function throws a NullPointerException().
        If an index is provided, but is out of bounds, the function throws an IndexOutOfBoundsException().
        If both are valid, then the function accesses and saves the value at the specified index in a separate variable.
        Then, it replaces the value at the specified index with the new provided value.
#### public int size()
    Functionality:
        There are no exceptions thrown or needed to be thrown for this one.
        It simply returns the number of values currently in this ArrayList.
            NOTE: This is NOT the number of elements the current array can hold. It is the number of elements the array currently has.
#### public List<E> subList(int fromIndex, int toIndex)
    Variables:
        int fromIndex:
            The location at which to start creating this subList. The subList is created inclusive of the value at this index.
        int toIndex:
            The location at which to end creating this sublist. The subList is created exclusive of the value at this index.
            This basically means that this variable could be equal to the number of values in this ArrayList, which, in turn, will produce all the values until the end.
    Throws:
        IndexOutOfBoundsException() if either or both of these indexes are out of bounds.
        IllegalArgumentException() if fromIndex is greater than toIndex, preventing the ArrayList object from creating a subList.
    Functionality:
        This function creates a list with values that are extracted from the range of the provided indexes, if they are valid and in bound.
#### public Object[] toArray()
    Functionality:
        This function creates a new array, copies the values in the current array up to the point where values actually exist by using the size variable, and returns that new array.
        By doing so, it creates this new array that is accessible to the user without needing to depend on the ArrayList.
        However, after that, the user will NOT be able to accommodate more space without actually manually creating a new array with more space and copying all the values into that new array.
#### public <T> T[] toArray(T[] a)
    Variables:
        T[] a:
            This is yet another generic array that has already been created by the user.
    Throws:
        NullPointerException() if no array 'a' is provided.
    Functionality:
        If no array 'a' is provided, the function throws a NullPointerException().
        If an array IS provided, then the function checks if the provided array has enough space to accommodate all the values in this ArrayList.
            If not, a new instance of an array with the appropriate size is created and assigned to array 'a'.
        Once that is done, the values in the current array are copied into array 'a'.
        Finally, if the array the user provided can still hold more values, the function sets them to null.
        Then, the function simply returns the modified array 'a'.
#### public String toString()
    Functionality:
        This overridden function creates a String implementation of this ArrayList through the user of the StringBuilder class in Java.
        It creates a String representation using StringBuilder to build it to look like an ArrayList similar to as follows:
            [item1, item2, item3, ..., itemN]
        where this is an ArrayList with N items.
