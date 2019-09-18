package cn.scl.demo02;

public class MaxSumRec {
    private static int maxSum(int[] arr, int left, int right) {
        //终止条件
        if (left == right) {
            if (arr[left] > 0) {
                return arr[left];
            }
            return 0;
        }
        int center = (left + right) >> 2;
        //最大序列在左部
        int maxLeftSum = maxSum(arr,left,center);
        //最大序列在右部
        int maxRightSum = maxSum(arr,center+1,right);

        return 0;
    }
}
