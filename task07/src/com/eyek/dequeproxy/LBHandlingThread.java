package com.eyek.dequeproxy;

import java.util.concurrent.*;

public class LBHandlingThread extends Thread {

    private static final int nThreads = 10;

    private final RequestQueue requestQueue;

    private final ThreadPoolExecutor threadPool;

    public LBHandlingThread(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
        this.threadPool = new ThreadPoolExecutor(nThreads, nThreads * 2,
                1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
    }

    @Override
    public void run() {
        while(!this.isInterrupted()) {
            if(this.threadPool.getQueue().size() == 0) {
                RequestElem requestElem = requestQueue.getOne();
                SocketProducer socketProducer = new MySocketProducer(requestElem.getChannel());
                threadPool.execute(socketProducer);
            }
            Thread.onSpinWait();
        }
    }
}
