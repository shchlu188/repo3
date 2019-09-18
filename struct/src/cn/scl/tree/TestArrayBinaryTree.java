package cn.scl.tree;

import java.util.Arrays;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree binaryTree = new ArrayBinaryTree(arr);
        binaryTree.heapSort(arr);
        System.out.println(Arrays.toString(arr));
}
}
