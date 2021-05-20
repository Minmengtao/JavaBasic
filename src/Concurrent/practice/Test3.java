package Concurrent.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: minmengtao
 * @date: 2021/5/20
 */
public class Test3 {
    public static class PrintNumberAndCharacter {
        static boolean flag = true;

        public synchronized void printNum(){
            for(int i = 1; i <= 52; i += 2) {
                while(!flag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(i);
                System.out.print(i + 1);
                flag = false;
                notify();
            }
        }

        public synchronized void printChar(){
            for(int i = 0; i < 26; i++) {
                while(flag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print((char)(i + 'A'));
                flag = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PrintNumberAndCharacter t = new PrintNumberAndCharacter();
        executorService.execute(() -> t.printNum());
        executorService.execute(() -> t.printChar());
        executorService.shutdown();
    }
}
