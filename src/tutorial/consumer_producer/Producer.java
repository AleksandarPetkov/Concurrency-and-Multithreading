package tutorial.consumer_producer;

public class Producer implements Runnable{

    protected StringBuffer stringBuffer;

     protected boolean dp;

    Producer()
    {
        stringBuffer = new StringBuffer(4);
    }



    @Override
    public void run()
    {
        synchronized (stringBuffer)
        {
            // Adding the data into the buffer
            for (int i = 0; i < 4; i++) {
                try {
                    stringBuffer.append(i);
                    System.out.println("Produced " + i);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Notifying the buffer
            System.out.println("Buffer is FUll");
            stringBuffer.notify();
        }
    }
}
