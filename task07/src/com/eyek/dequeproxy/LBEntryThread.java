package com.eyek.dequeproxy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.InvalidParameterException;

// load balance thread
public class LBEntryThread extends Thread {

    private final int port;
    private ServerSocketChannel serverSocketChannel;
    private final RequestQueue requestQueue;

    public LBEntryThread(int listenPort, RequestQueue requestQueue) {
        if(listenPort > 65535)
            throw new InvalidParameterException(String.format("Invalid listen port %d", listenPort));
        this.port = listenPort;
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        try {
            this.serverSocketChannel = ServerSocketChannel.open();
            this.serverSocketChannel.socket().bind(new InetSocketAddress(this.port));
            System.out.println(String.format("Listening on %s", this.serverSocketChannel.getLocalAddress().toString()));

            while (!this.isInterrupted()) {
                SocketChannel socketChannel = this.serverSocketChannel.accept();
                // System.out.println(String.format("Incoming request accepted from %s", socketChannel.getRemoteAddress().toString()));
                RequestElem elem = new RequestElem(socketChannel);
                requestQueue.addOne(elem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        if(this.serverSocketChannel != null)
            this.serverSocketChannel.close();
    }
}
