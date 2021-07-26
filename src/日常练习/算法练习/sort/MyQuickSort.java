package 日常练习.算法练习.sort;

public class MyQuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (right < left) {
            return;
        }
        int left0 = left;
        int right0 = right;
        //计算出基准数
        int baseNumber = arr[left0];
        while (left != right) {
            while (arr[right] >= baseNumber && right > left) {
                right--;
            }
            while (arr[left] <= baseNumber && right > left) {
                left++;
            }
            //3.交换两个值的位置
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        //基准数归位
        int temp = arr[left];
        arr[left] = arr[left0];
        arr[left0] = temp;

        quickSort(arr,left0,left-1);
        quickSort(arr,left+1,right0);
    }
}
