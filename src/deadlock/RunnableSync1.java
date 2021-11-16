package deadlock;

import java.util.Random;

public class RunnableSync1 implements Runnable{
    private Object lock1 = null;
    private Object lock2 = null;

    public RunnableSync1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " attempting to lock Resource 1");
        synchronized(lock1) {
            System.out.println(threadName + " locked Resource 1");
            try {
                Random random = new Random();
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                //ignore
            }
        }

        System.out.println(threadName + " attempting to lock Resource 2");
        synchronized (lock2) {
            System.out.println(threadName + " locked Resource 2");
            //do the work - now that both locks have been acquired (locked by this thread)

        }
        System.out.println(threadName + " unlocking Resource 2");
        System.out.println(threadName + " unlocking Resource 1");
    }
}
