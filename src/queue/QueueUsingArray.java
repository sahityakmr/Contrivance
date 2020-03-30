package queue;

public class QueueUsingArray {
    static class Queue<T>{
        int capacity;
        int size;
        int front;
        int rear;
        T[] baseArray;

        @SuppressWarnings("unchecked")
        public Queue(int capacity) {
            this.capacity = capacity;
            this.front = 0;
            this.rear = -1;
            baseArray = (T[])new Object[capacity];
        }

        public Queue() {
            this(10);
        }

        public void enqueue(T item) {
            if(isFull())
                increaseCapacity();
            size++;
            baseArray[rear = (rear + 1) % capacity] = item;
        }

        public T dequeue() {
            if(isEmpty())
                throw new NullPointerException("Empty Queue");
            size--;
            T item = baseArray[front];
            front = (front + 1) % capacity;
            return item;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        private boolean isFull() {
            return size == capacity;
        }

        @SuppressWarnings("unchecked")
        private void increaseCapacity() {
            T[] newArray = (T[]) new Object[capacity * 2];
            System.arraycopy(baseArray, front, newArray, 0, size);
            capacity *= 2;
            baseArray = newArray;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(13);
        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(13);
        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(13);
        queue.enqueue(10);
        queue.enqueue(9);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
