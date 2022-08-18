package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Operator implements Runnable {
    String name;
    ATC atc1;
    int sleepOperator = 300;

    public Operator(String name, ATC atc) {
        this.name = name;
        this.atc1 = atc;
    }

    @Override
    public void run() {
        for (int i = 0; i < atc1.calling; i++) {
            try {
                if (!atc1.blockingQueue.isEmpty())
                    System.out.println(name + " взял звонок " + atc1.blockingQueue.take());
                Thread.sleep(sleepOperator);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}