package DataStructures.Array;

/*
* implementation by William Fiset
* */
@SuppressWarnings("unchecked")
public class DynamicArray<T> {
    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray() {
        this.capacity = 16;
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.capacity = capacity;

        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index >= len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
    }

    public void clear() {
        for (int i = 0; i < len; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T element) {
        if (len + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;

        }
        arr[len] = element;
        len += 1;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        T data = arr[index];
        T[] newArr = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == index) {
                j--;
            } else {
                newArr[j] = arr[i];
            }
            arr = newArr;
            capacity = --len; // decrement first then store
        }
        return data;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        removeAt(index);
        return true;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (obj == null) {
                if (arr[i] == null) {
                    return i;
                }
            } else {
                if (obj.equals(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public String toString() {
        if (len == 0) {
            return "[]";

        } else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len; i++) {
                if (i != len - 1) {
                    sb.append(arr[i] + ", ");
                } else {
                    sb.append(arr[i]);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>(10);
        System.out.println(arr.size());
        arr.add(32);
        arr.add(12);
        arr.add(3);
        System.out.println(arr.size());
        System.out.println(arr);
    }
}
