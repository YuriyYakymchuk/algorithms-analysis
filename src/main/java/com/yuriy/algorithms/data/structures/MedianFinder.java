package com.yuriy.algorithms.data.structures;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minQueue;
    private PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((a, b) -> b -a);
    }

    public void addNum(int number) {
        if (maxQueue.isEmpty() || maxQueue.peek() >= number) {
            maxQueue.offer(number);
        } else {
            minQueue.offer(number);
        }
        balance();
    }

    private void balance() {
        if (maxQueue.size() - minQueue.size() > 1) {
            minQueue.offer(maxQueue.poll());
        } else if (minQueue.size() > maxQueue.size()) {
            maxQueue.offer(minQueue.poll());
        }
    }

    public double findMedian() {
        return maxQueue.size() == minQueue.size() ? (maxQueue.peek() + minQueue.peek()) * 0.5 : maxQueue.peek();
    }
}
