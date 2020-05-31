public class FixedList<T> implements List<T> {
    private T[] elements;
    private int numElem;

    @SuppressWarnings("unchecked")
    public FixedList(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.numElem = 0;
    }

    public String toString() {
        String s = "[ ";
        for (int i = 0; i < this.size(); i++) {
            s += "" + get(i) + " ";
        }
        s += "]";
        return s;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return elements[index];
    }

    public T set(int index, T element) throws IndexOutOfBoundsException {
        if (index >= numElem || index < 0)
            throw new IndexOutOfBoundsException();

        T oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }

    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index >= elements.length || this.numElem < index || elements.length == numElem || index < 0)
            throw new IndexOutOfBoundsException();

        //shift elements to right
        if (index != numElem) {
            for (int i = numElem; i > index; i--) {
                elements[i] = elements[i - 1];
            }
        }

        //set value and increment size
        elements[index] = element;
        numElem++;
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (numElem == 0 || index >= elements.length || index >= numElem || index < 0)
            throw new IndexOutOfBoundsException();

        //shift elements to left
        T oldValue = elements[index];
        if (index != numElem - 1) {
            for (int i = index; i < numElem - 1; i++) {
                elements[i] = elements[i + 1];
            }
        }

        //decrement size and return old value
        numElem--;
        return oldValue;
    }

    public int size() {
        return numElem;
    }

}
