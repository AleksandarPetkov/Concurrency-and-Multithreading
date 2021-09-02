package intro;

import constants.ThreadsColor;

public class Countdown {
    private int index;

    public void doCountdown(){
        String color;

        switch (Thread.currentThread().getName()){
            case "1":
                color = ThreadsColor.ANSI_RED;
                break;
            case "2":
                color = ThreadsColor.ANSI_BLUE;
                break;
            default:
                color = ThreadsColor.ANSI_GREEN;
        }

        //In this case we use instance variable and result is completely different
        //Because both threads shares same instance object and access same resources
        //We can fix that with 'synchronized' keyword 
        for (index = 10; index > 0; index--) {
            System.out.println(color +"Thread "+ Thread.currentThread().getName() + " i = "+ index);
        }

//        for (int i = 10; i > 0; i--) {
//            System.out.println(color +"Thread "+ Thread.currentThread().getName() + " i = "+ i);
//        }
    }
}
