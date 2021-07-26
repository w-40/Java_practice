package 日常练习.异常;

public class ExceptionDemo3 {
    public static void main(String[] args) {
        try {
            int[] arr = {1,2,3,4,5};
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
        /*   String message = e.getMessage();
            System.out.println(message);*/
           /* String s = e.toString();
            System.out.println(s);*/
            e.printStackTrace();
        }
        System.out.println("123");
    }
}
