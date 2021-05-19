package Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized关键字的使用
 * @author minmengtao
 * @date 2021-5-19
 */

//同步代码块
/*
它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。

对于以下代码，使用 ExecutorService 执行了两个线程，由于调用的是同一个对象的同步代码块，
因此这两个线程会进行同步，当一个线程进入同步语句块时，另一个线程就必须等待。
 */
class SynchronizedExample1 {
    public void func1() {
        synchronized (this) {
            for(int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}


//同步方法
class SynchronizedExample2{
    public synchronized void func1() {
        for(int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }
}

//同步类
class SynchronizedExample3 {
    public void func1() {
        synchronized (SynchronizedExample3.class) {
            for(int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}

public class SynchronizedTest {
    public static void main(String[] args) {
        /*同一个对象的两个线程同步代码块
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());
        */
        /*不同对象的两个线程同步代码块，运行结果交替输出
        SynchronizedExample1 e1 = new SynchronizedExample1();
        SynchronizedExample1 e2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());*/
        /*同一个对象的两个线程同步方法
        SynchronizedExample2 e1 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());*/
        SynchronizedExample3 e1 = new SynchronizedExample3();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e1.func1());
        executorService.shutdown();
    }
}
