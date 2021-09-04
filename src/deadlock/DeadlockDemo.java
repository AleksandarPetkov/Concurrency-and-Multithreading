package deadlock;

public class DeadlockDemo {
    public static void main(String[] args) {
        Resource lock1 = new Resource();
        Resource lock2 = new Resource();

        Runnable runnable1 = new RunnableSync1(lock1, lock2);
        Runnable runnable2 = new RunnableSync2(lock1, lock2);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

    }
}
