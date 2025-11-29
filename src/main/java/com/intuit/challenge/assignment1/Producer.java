package com.intuit.challenge.assignment1;

/**
 * Producer adds integers to the shared buffer.
 */
public class Producer implements Runnable {
    private final SharedBuffer buffer;
    private final int count;

    public Producer(SharedBuffer buffer, int count) {
        this.buffer = buffer;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                buffer.produce(i);
                System.out.println("Produced: " + i);
                Thread.sleep(100);
            }
            buffer.produce(-1); // termination signal
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
