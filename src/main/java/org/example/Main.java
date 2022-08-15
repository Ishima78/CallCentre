package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> call = new ArrayBlockingQueue<>(5);
        int calling = 60;
        new Thread(() -> {
            for (int i = 0; i < calling; i++) {
                try {
                    call.put("Звонок №" + (i + 1));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < calling / 2; i++) {
                try {
                    System.out.println("Оператор 1 взял звонок " + call.take());
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < calling / 2; i++) {
                try {
                    System.out.println("Оператор 2 взял звонок " + call.take());
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}