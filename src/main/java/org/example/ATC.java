package org.example;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ATC implements Runnable {
    int sleepATC = 100;
    BlockingQueue blockingQueue = new ArrayBlockingQueue(20);
    int calling = 60;

    @Override
    public void run() {
        for (int i = 0; i < calling; i++) {
            try {
                blockingQueue.offer("Звонок №" + (i + 1));
                // System.out.println(blockingQueue.take());
                Thread.sleep(sleepATC);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
