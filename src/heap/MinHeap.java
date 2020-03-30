package heap;

public class MinHeap {
    int size;
    int capacity;
    int[] baseArray;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        baseArray = new int[capacity];
    }

    public MinHeap(int[] baseArray) {
        this.baseArray = baseArray;
        this.capacity = baseArray.length;
        this.size = baseArray.length;
        for (int i = size / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public MinHeap() {
        this(16);
    }

    private void minHeapify(int index) {
        int smallest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < size && baseArray[smallest] > baseArray[left])
            smallest = left;
        if (right < size && baseArray[smallest] > baseArray[right])
            smallest = right;
        if (smallest != index) {
            int temp = baseArray[smallest];
            baseArray[smallest] = baseArray[index];
            baseArray[index] = temp;
            minHeapify(smallest);
        }
    }

    private int delete() {
        if (isEmpty())
            throw new NullPointerException("Empty Heap");
        int item = baseArray[0];
        baseArray[0] = baseArray[size - 1];
        size--;
        minHeapify(0);
        return item;
    }

    private void insert(int item) {
        if (isFull())
            increaseSize();
        baseArray[size] = item;
        size++;
        int i = size;
        while (i != 0) {
            i = (i - 1) / 2;
            minHeapify(i);
        }
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void increaseSize() {
        int[] newArray = new int[capacity * 2];
        System.arraycopy(baseArray, 0, newArray, 0, size);
        capacity *= 2;
        baseArray = newArray;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(new int[]{5, 1, 69, 4, 8, 4, 5, 4, 6, 7, 9, 5, 2, 1, 3, 4, 9, 7});
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(20);
        for (int i = 0; i < 20; i++) {
            System.out.println(minHeap.delete());
        }
    }
}
