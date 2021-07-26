package 日常练习.算法练习.sort;

public class MyBubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        //第一轮，-1是为了让索引不超过范围
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        PrintArr(arr);
        //第二轮
        for (int i = 0; i < arr.length - 2; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        PrintArr(arr);
        //第三轮
        for (int i = 0; i < arr.length - 3; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        PrintArr(arr);
        //第四轮
        for (int i = 0; i < arr.length - 4; i++) {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        PrintArr(arr);
    }





    private static void PrintArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
