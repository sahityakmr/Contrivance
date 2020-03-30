package heap;

public class MaxHeap {
    int size;
    int capacity;
    int[] baseArray;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        baseArray = new int[capacity];
    }

    public MaxHeap(int[] baseArray) {
        this.baseArray = baseArray;
        this.capacity = baseArray.length;
        this.size = baseArray.length;
        for (int i = size / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public MaxHeap() {
        this(16);
    }

    private void insert(int item) {
        if (isFull())
            increaseCapacity();
        baseArray[size] = item;
        int i = size;
        size++;
        while (i > 0) {
            i = (i - 1) / 2;
            maxHeapify(i);
        }
    }

    private int delete() {
        if (isEmpty())
            throw new NullPointerException("Empty Heap");
        int item = baseArray[0];
        baseArray[0] = baseArray[size - 1];
        size--;
        maxHeapify(0);
        return item;
    }

    private void maxHeapify(int index) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < size && baseArray[left] > baseArray[largest])
            largest = left;
        if (right < size && baseArray[right] > baseArray[largest])
            largest = right;
        if (largest != index) {
            int temp = baseArray[largest];
            baseArray[largest] = baseArray[index];
            baseArray[index] = temp;
            maxHeapify(largest);
        }
    }

    private boolean isFull() {
        return size == capacity;
    }

    private void increaseCapacity() {
        int[] newArray = new int[capacity * 2];
        System.arraycopy(baseArray, 0, newArray, 0, size);
        capacity *= 2;
        baseArray = newArray;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(new int[]{5, 1, 69, 4, 8, 4, 5, 4, 6, 7, 9, 5, 2, 1, 3, 4, 9, 7});
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(20);
        for (int i = 0; i < 20; i++) {
            System.out.println(maxHeap.delete());
        }
    }
}
