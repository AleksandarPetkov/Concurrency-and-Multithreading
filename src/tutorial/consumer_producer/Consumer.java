package tutorial.consumer_producer;

public class Consumer implements Runnable{

    Producer producer;

    Consumer(Producer temp)
    {
        producer = temp;
    }

    @Override
    public void run()
    {

        // Controlling the access of the
        // buffer to the shared producer
        synchronized (producer.stringBuffer)
        {
            try {
                producer.stringBuffer.wait();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            // Printing the values of the string buffer
            // and consuming the buffer
            for (int i = 0; i < 4; i++) {
                System.out.print(producer.stringBuffer.charAt(i) + " ");
            }
            System.out.println("\nBuffer is Empty");
        }
    }
}
