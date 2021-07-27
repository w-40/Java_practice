package 日常练习.多线程.原子性.使用锁解决原子性问题案例;

public class AtomDemo {
    public static void main(String[] args) {
        MyAtomThread atom = new MyAtomThread();
        for (int i = 0; i < 100; i++) {
            new Thread(atom).start();
        }
    }
}
