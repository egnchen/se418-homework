package com.eyek.dequeproxy;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class MySocketProducer implements SocketProducer {

    public static final double meanDelayTimeMillis = 250;
    public static final double deviationDelayTimeMillis = 30;

    private final SocketChannel socketChannel;

    MySocketProducer(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            System.out.println(String.format("Handling request, thread id %d", Thread.currentThread().getId()));

            ByteBuffer buffer = ByteBuffer.allocate(512);
            socketChannel.read(buffer);


            // parse HTTP request
            // we only need the first line
            String requestString = new String(buffer.array(), 0, buffer.position());
            requestString = requestString.substring(0, requestString.indexOf("\r\n"));
            // parse first line
            String[] splitted = requestString.split("\\s+");
            if (splitted.length != 3)
                throw new RuntimeException(String.format("Invalid request: %s", requestString));
            String method = splitted[0], path = splitted[1], version = splitted[2];

            if (!method.equals("GET"))
                throw new RuntimeException(String.format("Unsupported method: %s", method));

            // sleep for a random period of time
            // to imitate the behavior of code execution
            double delay = (new Random().nextGaussian()) * deviationDelayTimeMillis + meanDelayTimeMillis;
            Thread.sleep(Math.round(delay));

            // return
            buffer.flip();
            buffer.put(String.format("%s 200 OK", version).getBytes());
            socketChannel.write(buffer);
            socketChannel.close();
            System.out.println("Handle complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
