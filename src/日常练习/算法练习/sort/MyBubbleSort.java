package 日常练习.算法练习.sort;

public class MyBubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        //外层循环控制次数，比数组的长度少一次
        bubblesort(arr);
        PrintArr(arr);
    }

    private static void bubblesort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环是实际循环比较的
            //-1是为了让数组不要越界
            //-1每一轮结束之后，我们就会少比一个数字
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void PrintArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}