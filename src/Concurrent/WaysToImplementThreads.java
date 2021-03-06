package Concurrent;

import java.util.concurrent.*;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        // ...
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // ...
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        return 123;
    }

}

public class WaysToImplementThreads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //继承Thread类
        MyThread mt = new MyThread();
        mt.start();

        //实现Runnable接口，实现接口的run()，创建Thread实例，调用Thread实例的start()
        MyRunnable instance = new MyRunnable();
        Thread thread1 = new Thread(instance);
        thread1.start();

        //实现Callable接口，可以又返回值，返回值通过FutureTask封装
        MyCallable mc = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(mc);
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        System.out.println(futureTask.get());

        //线程池实现线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
