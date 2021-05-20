package Concurrent.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test6 implements Runnable{
    static int total = 100;//一共有100张票

    @Override
    public void run() {
        while(total > 0) {
            synchronized (this) {
                if(total > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + total + "张票");
                    total--;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Test6 e = new Test6();
        for(int i = 0; i < 3; i++) {
            executorService.execute(() -> e.run());
            //new Thread(e, "窗口" + i).start();
        }
        executorService.shutdown();
    }
}
