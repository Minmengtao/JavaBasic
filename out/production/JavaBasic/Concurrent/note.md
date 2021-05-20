### [PrintOddAndEven](https://www.cnblogs.com/grey-wolf/p/11217164.html#_label2)
给定两个线程，交替打印奇偶数

三种方法实现交替打印

### WaysToImplementThreads
实现线程的三种方法

1.继承Thread类

2.实现Runnable接口

3.实现Callable接口

### SynchronizedExample

[互斥同步的三种](SynchronizedTest.java)

1.同步代码块

2.同步方法

3.同步类

### ReentrantLock

使用J.U.C包中的ReentrantLock

### 使用比较
1. 锁的实现

synchronized是 JVM 实现的，而 ReentrantLock 是 JDK 实现的。

2. 性能

新版本 Java 对 synchronized 进行了很多优化，例如自旋锁等，synchronized 与 ReentrantLock 大致相同。

3. 等待可中断

当持有锁的线程长期不释放锁的时候，正在等待的线程可以选择放弃等待，改为处理其他事情。

ReentrantLock 可中断，而 synchronized 不行。

4. 公平锁

公平锁是指多个线程在等待同一个锁时，必须按照申请锁的时间顺序来依次获得锁。

synchronized 中的锁是非公平的，ReentrantLock 默认情况下也是非公平的，但是也可以是公平的。

5. 锁绑定多个条件

一个 ReentrantLock 可以同时绑定多个 Condition 对象。


