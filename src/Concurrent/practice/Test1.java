package Concurrent.practice;

public class Test1 extends Thread{

    public Test1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "在工作");
    }

    public static void main(String[] args) throws InterruptedException {
        Test1 e1 = new Test1("线程a");
        Test1 e2 = new Test1("线程b");
        Test1 e3 = new Test1("线程c");

        e1.start();
        e1.join();
        e2.start();
        e2.join();
        e3.start();
        e3.join();

    }
}
