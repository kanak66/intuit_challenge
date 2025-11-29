package com.intuit.challenge.assignment1;

import java.util.List;

/**
 * Consumer takes values from the buffer and stores them into destination list.
 */
public class Consumer implements Runnable {
    private final SharedBuffer buffer;
    private final List<Integer> destination;

    public Consumer(SharedBuffer buffer, List<Integer> destination) {
        this.buffer = buffer;
        this.destination = destination;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int val = buffer.consume();
                if (val == -1) break; // termination signal
                destination.add(val);
                System.out.println("Consumed: " + val);
                Thread.sleep(120);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
