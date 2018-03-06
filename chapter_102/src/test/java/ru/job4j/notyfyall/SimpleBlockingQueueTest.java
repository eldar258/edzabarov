package ru.job4j.notyfyall;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Class ru.job4j.notyfyall.
 *
 * @author edzabarov
 * @since 06.03.2018
 */
public class SimpleBlockingQueueTest {
    int n = 1000000;

    private class Producer implements Runnable {
        private SimpleBlockingQueue<Integer> simpleBlockingQueue;

        public Producer(SimpleBlockingQueue<Integer> simpleBlockingQueue) {
            this.simpleBlockingQueue = simpleBlockingQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                try {
                    simpleBlockingQueue.offer(i);
                    if (simpleBlockingQueue.size() > 10) System.out.println("Producer malfunctioning");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Consumer implements Runnable {
        private SimpleBlockingQueue<Integer> simpleBlockingQueue;

        public Consumer(SimpleBlockingQueue<Integer> simpleBlockingQueue) {
            this.simpleBlockingQueue = simpleBlockingQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < n; i++) {
                try {
                    if (simpleBlockingQueue.peek() == null) System.out.println("Consumer malfunctioning");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void whenProducerAddQueueThenConsumerPeekQueue() {
        SimpleBlockingQueue<Integer> simple = new SimpleBlockingQueue<>();
        Thread producer = new Thread(new Producer(simple));
        Thread consumer = new Thread(new Consumer(simple));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int expected = simple.size();
        int result = 0;

        assertThat(expected, is(result));
    }

}