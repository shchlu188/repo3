package cn.scl.arr;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] arr = {34, 54, 2, 5, 5, 6, 3, 78, 35, 8, 10, 17};
        int[] arr1 = {34, 54, 2, 5, 5, 6, 3, 78, 35, 8, 10, 17};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------------------");
        bubbleSort01(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                count++;
            }
        }
        System.out.println("count:" + count);
    }

    /**
     * 改进冒泡
     * @param arr
     */
    public static void bubbleSort01(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
                count++;
            }
            if (flag){
                break;
            }
        }
        System.out.println("count:" + count);
    }

    /**
     * 快排
     */

    public static void test01(int[] arr, int start, int end) {
        while (start < end) {
            int stard = arr[start];
            int low = stard;
            int high = end;
            while (low < high) {
                while (low < high && stard < arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] < stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stard;
            test01(arr, 0, low);
            test01(arr, low + 1, end);
        }
    }

    /**
     * 直接插入排序
     */
    public static void teset02(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                int tmp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && tmp > arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = tmp;
            }
        }
    }

    /**
     * 希尔排序
     */
    public static void test03(int[] arr) {
        for (int d = arr.length / 2; d > 0; d /= 2) {
            for (int i = d; i < arr.length; i++) {
                for (int j = i - d; j >= 0; j -= d) {
                    if (arr[j] > arr[j + d]) {
                        int tmp = arr[j + d];
                        arr[j + d] = arr[j];
                        arr[j] = tmp;
                    }

                }
            }
        }
    }

    /**
     * 简单选择排序
     */
    public static void test04(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int mindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[mindex] > arr[j]) {
                    mindex = j;
                }
            }
            if (mindex != i) {
                int tmp = arr[i];
                arr[i] = arr[mindex];
                arr[mindex] = tmp;
            }
        }
    }

    /**
     * 归并排序
     */
    public static void test05(int[] arr, int low, int middle, int high) {
        int[] tmp = new int[high - low + 1];
        int index = 0;
        int oneArr = low;
        int twoArr = middle + 1;
        while (oneArr < middle && twoArr < high) {
            if (arr[oneArr] > arr[twoArr]) {
                tmp[index] = arr[oneArr];
                oneArr++;
            } else {
                tmp[index] = arr[twoArr];
                twoArr++;
            }
            index++;
        }
        while (oneArr <= middle) {
            tmp[index] = arr[oneArr];
            oneArr++;
            index++;
        }
        while (twoArr <= high) {
            tmp[index] = arr[twoArr];
            index++;
            twoArr++;
        }
        for (int k = 0; k < tmp.length; k++) {
            arr[k + low] = tmp[k];
        }
    }

    public static void test06(int[] arr, int low, int high) {
        int mid = (high - low) / 2;
        if (low < high) {
            test06(arr, low, mid);
            test06(arr, mid + 1, high);
            test05(arr, low, mid, high);
        }
    }

}
