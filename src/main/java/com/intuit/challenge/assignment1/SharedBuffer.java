package com.intuit.challenge.assignment1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Shared bounded buffer implemented with wait/notify.
 */
public class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // wait if buffer full
        }
        queue.add(value);
        notifyAll(); // notify consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wait if buffer empty
        }
        int val = queue.poll();
        notifyAll(); // notify producer
        return val;
    }
}
