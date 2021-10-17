package 算法.最大公约数;

public class FindGcd {

    public int f(int a, int b) {
        int c = b;
        while (a % b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return c;
    }
}
