package Concurrent.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static class PrintNumber {
        static boolean flag = true;

        public synchronized void print1(){
            for(int i = 1; i <= 100; i += 2) {
                while(!flag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(i + " ");
                flag = false;
                notify();
            }
        }

        public synchronized void print2(){
            for(int i = 2; i <= 100; i += 2) {
                while(flag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(i + " ");
                flag = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PrintNumber t = new PrintNumber();
        executorService.execute(() -> t.print1());
        executorService.execute(() -> t.print2());
        executorService.shutdown();
    }
}
