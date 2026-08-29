import java.util.*;

class MedianFinder {

    // Smaller half
    // Largest element is at the top
    PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>(Collections.reverseOrder());

    // Larger half
    // Smallest element is at the top
    PriorityQueue<Integer> minHeap =
        new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {

        // Step 1: Add to max heap
        maxHeap.offer(num);

        // Step 2: Move largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance the heaps
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        // Even number of elements
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}