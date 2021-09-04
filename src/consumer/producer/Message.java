package consumer.producer;

public class Message {
    String message;
    boolean empty = true;

//    Reader reads the message when it is not empty otherwise it will wait for the Writer to write the message.
//    On the other hand, Writer writes the message when it is empty else it waits for Reader to read the message
//    and marks the message empty.

    //Method used by reader
    public synchronized String read() {
        while (empty) ;//if message is empty then keep looping.
        empty = true;//Reader reads the message and marks empty as true.
        return message;//Reader reads the message.
    }

    //Method used by writer
    public synchronized void write(String message) {
        while (!empty) ;//if message is not empty then keep looping.
        this.message = message;//Writer writes the message.
        empty = false;//Now make empty as false.
    }
}
