package tutorial.deadlock;

import java.util.concurrent.locks.Lock;

public class Runnable2 implements Runnable{

    private Lock resource1;
    private Lock resource2;

    public Runnable2(Lock lock1, Lock lock2) {
        this.resource1 = lock1;
        this.resource2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        //lock Second resource
        System.out.println(threadName + " Attempting to Lock resource2");
        resource2.lock();
        System.out.println(threadName + " Lock resource2");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //lock First resource
        System.out.println(threadName + " Attempting to Lock resource1");
        resource1.lock();
        System.out.println(threadName + " Lock resource1");

        //unlock
        System.out.println(threadName + " Unlock resource1");
        resource1.unlock();
        System.out.println(threadName + " Unlock resource2");
        resource2.unlock();
    }
}
