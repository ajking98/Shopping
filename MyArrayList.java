/**
 * @author Ahmed Gedi
 * @version 1.0
 */
import java.util.Iterator;

/**
 * @author Ahmed Gedi
 * @version 1.0
 *
 * MyArrayList the name os the class
 * @param <E> the generic type
 */
public class MyArrayList<E> implements ArrayListInterface<E> {

    private E[] elements;
    private int numElements;

    /**
     *
     */
    public MyArrayList() {
        this.elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * @return MyArrayListIterator
     */
    public Iterator<E> iterator() {
        return new MyArrayListIterator();

    }

    /**
     * @return get(cursor++)
     * @return cursor less than numElements
     */
    private class MyArrayListIterator implements Iterator<E> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < numElements;
        }

        @Override
        public E next() {
            return get(cursor++);
        }

        public void remove() {
            MyArrayList.this.remove(cursor - 1);
        }
    }

    /**
     * Adds the element to the last position in the array list
     * @throws IllegalArgumentException if element is null
     * @param e the element to be added to the array list
     */
    public void add(E e) throws IllegalArgumentException {

        if (e == null) {
            throw new IllegalArgumentException();

        } else {
            if (this.size() == elements.length) {
                E[] secondArray = (E[]) new Object[elements.length * 2 + 1];
                int count = 0;
                for (E element : elements) {
                    secondArray[count] = elements[count];
                    count++;

                }
                elements = secondArray;
            }
            elements[this.size()] = e;
            numElements++;
        }
    }

    /**
     * Removes all instance of the passed in element from the
     * array list then returns the element that was removed
     * or null if the element was not contained in the array list
     * @throws IllegalArgumentException if element is null
     * @param e the element to be removed
     * @return E the element removed
     */
    public E removeAll(E e) throws IllegalArgumentException {
        boolean there = false;
        if (e == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < this.numElements; i++) {
            if (e == this.elements[i]) {
                this.elements[i] = null;
                for (int j = i; j < this.numElements - 1; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                there = true;
                this.numElements--;
            }
            if (!(there)) {
                return null;
            }

        } return e;
    }

    /**
     * Removes the element at the passed in index from the
     * array list then returns the element that was removed
     * or null if the element was not contained in the array list
     * @throws IndexOutOfBoundsException if index is less than
     * zero or greater than or equaled to the number of elements
     * in the array list
     * @param index the index of the element to be removed
     * @return the element that was removed
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index <= 0 || index > numElements) {
            throw new IndexOutOfBoundsException();
        }

        E stuff = this.elements[index];
        this.elements[index] = null;
        for (int i = index; i < this.numElements; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.numElements--;
        return stuff;
    }

    /**
     * Returns the element at the passed in index of the array list
     * Does not remove the element from the array list
     * @throws IndexOutOfBoundsException if index is less
     * than zero or greater than or equaled to the number of
     * elements in the array list
     * @param index the index of the element in the array list
     * @return the element at the given index in the array list
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.numElements) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
        // try {
        //     if (index < 0 || index >= numElements) {
        //         throw new IndexOutOfBoundException();
        //     }
        //     else {
        //         return elements[index];
        //     }
        // }
        // catch (IndexOutOfBoundException index) {

        // }


    }

    /**
     * Removes all elements from array list and sets array list
     * back to original capacity
     */
    public void clear() {
        for (int i = 0; i < this.numElements; i++) {
            this.elements[i] = null;
        }
        numElements = 0;
    }

    /**
     *@return size of set
     */
    public int size() {
        int count = 0;
        for (E element : elements) {
            if (element != null) {
                count++;
            }

        }
        return count;
    }

    /**
    * @return true if empty
    */
    public boolean isEmpty() {
        if (numElements >= 1) {
            return false;
        }
        return true;
    }

}
