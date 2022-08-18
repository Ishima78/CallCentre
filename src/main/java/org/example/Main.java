package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ATC atc = new ATC();
        Thread t1 = new Thread(atc);
        Operator operator = new Operator("Оператор 1", atc);
        Thread t2 = new Thread(operator);
        Operator operator1 = new Operator("Оператор 2 ", atc);
        Thread t3 = new Thread(operator1);
        t1.start();
        t2.start();
        t3.start();

    }
}