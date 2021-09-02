package intro.threads;

import intro.Countdown;

public class CountdownThread implements Runnable{
    private Countdown countdownThread;

    public CountdownThread(Countdown countdown){
        this.countdownThread = countdown;
    }

    @Override
    public void run() {
        countdownThread.doCountdown();
    }
}
