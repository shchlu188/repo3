package cn.scl.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
    }
}
