package cn.scl.demo02;

public class MaxTest {
    public static void main(String[] args) {
        int[] arr = {4, -3, 5, -2, -1, 2, 6, -2};
        System.out.println(max(arr));
    }

    public static int max(int[] arr) {
        int maxValue = 0;
        int currentValue = 0;
        for (int i = 0; i < arr.length; i++) {
            currentValue += arr[i];
            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
            if (currentValue < 0)

                currentValue = 0;
        }
        return maxValue;
    }
}
