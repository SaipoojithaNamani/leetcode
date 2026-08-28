import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min heap based on frequency
        PriorityQueue<Integer> heap =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        // Keep only k most frequent elements
        for (int num : map.keySet()) {

            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Build answer
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}