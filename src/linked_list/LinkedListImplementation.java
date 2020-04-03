package linked_list;

public class LinkedListImplementation {
    static class LinkedList<T> {
        T[] baseArray;

        public void insertAtBeginning(T item) {

        }

        public void insertAtEnd(T item) {

        }

        public void insertAtIndex(T item, int index) {

        }

        public T deleteAtBeginning() {
            return null;
        }

        public T deleteAtEnd() {
            return null;
        }

        public T deleteAtIndex(int index) {
            return null;
        }

        public void traverse() {

        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.insertAtBeginning(5);
        linkedList.insertAtBeginning(12);
        linkedList.insertAtBeginning(69);
        linkedList.insertAtBeginning(76);
        linkedList.insertAtEnd(15);
        linkedList.insertAtEnd(34);
        linkedList.insertAtEnd(94);
        linkedList.insertAtEnd(17);
        linkedList.insertAtIndex(5, 1);
        linkedList.insertAtIndex(16, 5);
        linkedList.insertAtIndex(11, 9);
        linkedList.traverse();
        System.out.println(linkedList.deleteAtEnd());
        System.out.println(linkedList.deleteAtEnd());
        System.out.println(linkedList.deleteAtBeginning());
        System.out.println(linkedList.deleteAtBeginning());
        System.out.println(linkedList.deleteAtIndex(5));
        System.out.println(linkedList.deleteAtIndex(5));
        linkedList.traverse();
    }
}
