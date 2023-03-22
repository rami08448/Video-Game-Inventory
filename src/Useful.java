import java.nio.BufferUnderflowException;

public class Useful<E> {

    private NodeLink<E> mTop;
    private int mSize;


    public Useful() {
        mTop = null;
        mSize = 0;
    }

    public E peek() {
        if (!isEmpty())
            return mTop.memory;
        else
            return null;

    }

    public void push(E node) {
        NodeLink<E> index = new NodeLink<>(node);
        index.next = mTop;
        mTop = index;
        mSize++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        E node = mTop.memory;
        mTop = mTop.next;
        mSize--;

        return node;
    }

    public boolean isEmpty() {

        return mTop == null;
    }

    public int size() {

        return mSize;
    }

    public String toString() {

        StringBuilder number = new StringBuilder();
        NodeLink<E> here = mTop;
        while (here != null) {

            number.append(here.memory);
            number.append(", ");
            here = here.next;

        }
        return number.toString();
    }
}


