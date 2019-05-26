package com.eyek.dequeproxy;

public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        LBEntryThread entryThread = new LBEntryThread(9000, requestQueue);
        LBHandlingThread handlingThread = new LBHandlingThread(requestQueue);

        entryThread.start();
        handlingThread.start();
    }
}
