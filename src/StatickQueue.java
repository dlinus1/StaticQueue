import java.util.Arrays;

/**
 * Created by 17623 on 4/23/15.
 */
public class StatickQueue<T> {
    private final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;
    private int first, last;

    public StatickQueue() {
        data = new Object[DEFAULT_SIZE];
    }

    public StatickQueue(int size) {
        data = new Object[size];
    }

    public int size() {
        return size;
    }

    public void enqueue(Object o) {
        if(last + 1 == data.length) {
            if (data[0] == null) {
                data[last] = o;
                last = 0;
                size++;
                return;
            }
            else {
                Object[] temp = new Object[2 * data.length];
                for (int i = 0; i < data.length; i++) {

                    temp[i] = data[(first + i) % data.length];
                    first = 0;
                    data = temp;
                    last = size;
                }
            }
        }
        else if(data[last+1]!=null) {
            Object[] temp = new Object[2*data.length];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(first + i) % data.length];
            }
            first = 0;
            last = size;
            data = temp;

        }
        data[last++] = o;
        size++;

    }

    public T dequeue() {
        if(size==0) {
            return null;
        }
        size--;
        if(first + 1 == data.length) {
            T t = (T)data[first];
            data[first] = null;
            first = 0;
            return t;
        }
        T t = (T)data[first];
        data[first++] = null;
        return t;

    }

    public T front() {
        if(isEmpty())
            return null;
        return (T)data[0];
    }

    public void clear() {
        data =  new Object[DEFAULT_SIZE];
    }

    public boolean isEmpty() {
        return data.length==0;
    }
    public String toString() {
        return Arrays.toString(data);
    }

    public T getNext() {
        return (T)data[last-1];
    }
}
