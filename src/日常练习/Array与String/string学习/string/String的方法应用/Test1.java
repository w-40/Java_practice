package 日常练习.Array与String.string学习.string.String的方法应用;
//用户登录实例
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        String username = "admin";
        String password = "123456";
        Scanner sc = new Scanner(System.in);
        for(int i = 1;i <= 3; i++){
            System.out.println("Please input username:");
            String scUsername = sc.nextLine();
            System.out.println("Please input password:");
            String scPassword = sc.nextLine();
            if(username.equals(scUsername)&&password.equals(scPassword)){
                System.out.println("登陆成功");
                break;
            }else{
                if(i == 3){
                    System.out.println("您的登录次数已达今日上限，请明天再来");
                }else{
                    System.out.println("登陆失败，您还剩"+(3-i)+"次机会");
                }
            }
        }

    }
}
