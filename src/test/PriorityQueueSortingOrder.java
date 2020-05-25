package test;

import java.util.Comparator;
import java.util.TreeSet;

public class PriorityQueueSortingOrder {
    static class Item{
        String name;
        int qty;

        public Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        TreeSet<Item> priorityQueue = new TreeSet<>(Comparator.comparingInt(item -> item.qty));
        priorityQueue.add(new Item("Mango", 30));
        priorityQueue.add(new Item("Banana", 30));
        priorityQueue.add(new Item("Orange", 30));

        System.out.println(priorityQueue.pollFirst().name);
        System.out.println(priorityQueue.pollFirst().name);
        System.out.println(priorityQueue.pollFirst().name);
    }
}
