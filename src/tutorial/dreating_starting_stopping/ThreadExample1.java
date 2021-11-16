package tutorial.dreating_starting_stopping;

public class ThreadExample1 {

    /**
     *  1: Creating Thread using Base Class
     */
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("My Thread Running");
        }
    }


    /**
     *  2: Creating Thread using Interface
     */
    public static class MyRunnable implements Runnable   {

        @Override
        public void run() {
            System.out.println("My Runnable Running");
        }
    }

    public static void main(String[] args) {
        // 1: Creating Thread using Base Class
       MyThread myThread = new MyThread();
       myThread.start();

       // 2: Creating Thread using Interface
        Thread thread = new Thread(new MyRunnable());

        /**
         *  3: Creating Thread using Anonymous Class
         */
        Runnable anonymousRunnable = new Runnable() {
            //Get name
            String name = Thread.currentThread().getName();
            @Override
            public void run() {

                //Thread sleep()
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(name + "Runnable Running");
            }
        };
        Thread anonymousThread = new Thread(anonymousRunnable);

        /**
         *  4: Creating Thread using Lambda
         */
        Runnable lambdaRunnable = () -> {
            System.out.println("Lambda Running");
        };
        Thread lambdaThread = new Thread(lambdaRunnable);

    }
}
