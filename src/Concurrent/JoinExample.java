package Concurrent;

/**
 * 在线程调用目标线程的join()方法，直到目标线程结束，才会执行
 * @author minmengtao
 * @date 2021-5-19
 */
public class JoinExample {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class C extends Thread {
        @Override
        public void run() {
            System.out.println("C");
        }
    }

    private class B extends Thread {

        private A a;
        private C c;
        B(A a, C c) {
            this.a = a;
            this.c = c;
        }
        @Override
        public void run() {
            try {
                a.join();
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() {
        A a = new A();
        C c = new C();
        B b = new B(a, c);
        a.start();
        c.start();
        b.start();

    }
    public static void main(String[] args) {
        JoinExample example = new JoinExample();
        example.test();
    }
}
