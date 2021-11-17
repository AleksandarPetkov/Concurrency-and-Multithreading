package tutorial.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockMain {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread runnable1 = new Thread(new Runnable1(lock1, lock2));
        Thread runnable2 = new Thread(new Runnable2(lock1, lock2));

        runnable1.start();
        runnable2.start();
    }
}
