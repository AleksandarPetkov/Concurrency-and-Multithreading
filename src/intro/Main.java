package intro;

import intro.threads.CountdownThread;

public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        Thread t1 = new Thread(new CountdownThread(countdown));
        t1.setName("1");
        Thread t2 = new Thread(new CountdownThread(countdown));
        t2.setName("2");

        t1.start();
        t2.start();
    }
}
