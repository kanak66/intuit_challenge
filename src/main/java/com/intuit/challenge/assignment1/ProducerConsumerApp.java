package com.intuit.challenge.assignment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Main app to run Producer-Consumer demonstration.
 */
public class ProducerConsumerApp {
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer buffer = new SharedBuffer(5);
        List<Integer> consumed = new ArrayList<>();

        Thread producer = new Thread(new Producer(buffer, 10));
        Thread consumer = new Thread(new Consumer(buffer, consumed));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("\nFinal consumed items: " + consumed);
    }
}
