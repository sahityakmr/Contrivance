package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class TreeSetSortingOrder {
    public static void main(String[] args) {
        TreeSet<MyObj> treeSet = new TreeSet<>(Comparator.comparingInt(o -> o.data));
        treeSet.add(new MyObj("Sahitya", 230));
        treeSet.add(new MyObj("Peeyush", 250));
        System.out.println(Arrays.toString(treeSet.toArray()));
        Objects.requireNonNull(treeSet.first()).data = 300;
        System.out.println(Arrays.toString(treeSet.toArray()));
    }

    static class MyObj{
        String name;
        int data;

        public MyObj(String name, int data) {
            this.name = name;
            this.data = data;
        }

        @Override
        public String toString() {
            return "MyObj{" +
                    "name='" + name + '\'' +
                    ", data=" + data +
                    '}';
        }
    }
}
