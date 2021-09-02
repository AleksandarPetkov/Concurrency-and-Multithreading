package messages;

import java.util.Random;

public class Writer implements Runnable{
    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"1 message", "2 message" ,"3 message" ,"4 message"};
        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            this.message.write(messages[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }
        message.write("FINISH");
    }
}
