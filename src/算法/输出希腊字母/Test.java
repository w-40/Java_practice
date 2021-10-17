package 算法.输出希腊字母;

class A {
    public final void f() {
        char start = 'a', end = 'z';
        for (char c = start; c <= end; c++)
            System.out.print(c + " ");
    }
}

class B extends A {
    public void g() {
        char start = 'α', end = 'ω';
        for (char c = start; c <= end; c++)
            System.out.print(c + " ");
    }
}

public class Test {
    public static void main(String args[]) {
        A a = new A();
        a.f();
        System.out.println();
        B b = new B();
        b.f();
        System.out.println();
        b.g();
    }
}
