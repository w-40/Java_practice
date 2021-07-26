package 日常练习.异常;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        int[] arr = null;
       // printArr(arr);//接收一个异常，并抛给虚拟机
        try{
            printArr(arr);
        }catch (NullPointerException e){
            System.out.println("参数不能为null");
        }
        System.out.println("代码继续运行");
    }

    private static void printArr(int[] arr) {
        if (arr == null) {
            throw new NullPointerException();//当参数为null时，手动创建一个异常对象，抛给调用者
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }

    }
}
