package stack;

import java.lang.reflect.Array;

public class StackUsingArray {
    static class Stack<T>{
        int size;
        int top;
        T[] baseArray;

        @SuppressWarnings("unchecked")
        public Stack(int size) {
            this.size = size;
            this.top = -1;
            baseArray = (T[]) new Object[size];
        }

        public Stack() {
            this(10);
        }

        public void push(T item){
            if(isFull())
                increaseSize();
            baseArray[++top] = item;
        }

        public T pop(){
            if(isEmpty())
                throw new NullPointerException("Empty Stack");
            return baseArray[top--];
        }

        public T peek(){
            if(isEmpty())
                return null;
            return baseArray[top];
        }

        private boolean isFull() {
            return top == size;
        }

        @SuppressWarnings("unchecked")
        private void increaseSize() {
            T[] newArray = (T []) new Object[size * 2];
            if (size >= 0) System.arraycopy(baseArray, 0, newArray, 0, size);
            size *= 2;
            baseArray = newArray;
        }

        private boolean isEmpty() {
            return top == -1;
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(15);
        stack.push(10);
        stack.push(1);
        stack.push(2);
        stack.push(25);
        stack.push(11);
        stack.push(60);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(25);
        stack.push(11);
        stack.push(60);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
