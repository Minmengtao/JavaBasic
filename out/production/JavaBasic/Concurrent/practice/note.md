[八个经典的多线程编程题目](https://blog.csdn.net/shinecjj/article/details/103792151)

1、要求线程a执行完才开始线程b, 线程b执行完才开始线程

2、两个线程轮流打印数字，一直到100

3、写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B...5152Z

4、编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...

5、编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。

6 、三个窗口同时卖票

7、 生产者消费者
7.1 synchronized方式
7.2 ReentrantLock方式 (可以保证顺序)
7.3 BlockingQueue方式

8、交替打印两个数组