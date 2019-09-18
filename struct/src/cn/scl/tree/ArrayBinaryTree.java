package cn.scl.tree;

public class ArrayBinaryTree {
    private int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow(int start) {
        if (data == null || data.length == 0) {
            return;
        }
        System.out.println(data[start]);
        if (2 * start + 1 < data.length) {
            frontShow(2 * start + 1);
        }
        if (2 * start + 2 < data.length) {
            frontShow(2 * start + 2);
        }
    }

    /**
     * 堆排序
     * 从后往前，处理非叶子节点
     */
    public void heapSort(int[] data) {
        int start = (data.length - 1) >> 1;
        for (int i = start; i >= 0; i--) {
            maxHeap(data, data.length, i);
        }
        for (int i = data.length - 1; i >= 0; --i) {
            int tmp = data[0];
            data[0] = data[i];
            data[i] = tmp;
            maxHeap(data, i, 0);
        }

    }

    /**
     * @param arr   数组
     * @param size  数组长度
     * @param index 数组下标
     */
    private void maxHeap(int[] arr, int size, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
//        if (left < size && arr[left] > arr[max]) {
//            max = left;
//        }
//        if (right < size && arr[right] > arr[max]) {
//            max = right;
//        }
        if(left < size){
            max = arr[left] > arr[max] ? left:max;
        }
        if(right < size){
            max = arr[right] > arr[max] ? right:max;
        }
        if (max != index) {
            int tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            maxHeap(arr, size, max);
        }

    }
}
