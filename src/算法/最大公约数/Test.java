package 算法.最大公约数;

public class Test {
    public static void main(String[] args) {
        FindGcd a = new FindGcd();
        int gcd = a.f(12,20);
        System.out.println(gcd);
        a = new FindLcm();
        int lcm = a.f(12,20);
        System.out.println(lcm);
    }
}
