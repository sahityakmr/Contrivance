package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRemove {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(450);
        list.add(5);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(new Integer(450));
        System.out.println(Arrays.toString(list.toArray()));
        Integer i1 = 450;
        Integer i2 = 450;
        System.out.println(i1.equals(i2));
    }
}
