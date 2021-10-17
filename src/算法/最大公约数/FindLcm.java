package 算法.最大公约数;

public class FindLcm extends FindGcd {
    @Override
    public int f(int a, int b) {
        int m = super.f(a, b);
        return (a * b) / m;
    }
}
