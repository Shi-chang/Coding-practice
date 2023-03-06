import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Bucket sort (n)
class LC347TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (Integer num : map1.keySet()) {
            Integer freq = map1.get(num);

            if (!map2.containsKey(freq)) {
                map2.put(freq, new ArrayList<>());
            }

            map2.get(freq).add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0; i--) {
            if (map2.containsKey(i)) {

                for (int cur : map2.get(i)) {
                    res[index++] = cur;

                    if (index == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}

// // Heap sort(n log n)
// class LC347TopKFrequentElements {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         }

//         Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
//         for (Integer num : map.keySet()) {
//             minHeap.offer(num);

//             if (minHeap.size() > k) {
//                 minHeap.poll();
//             }
//         }

//         int index = 0;
//         int[] res = new int[k];
//         while (!minHeap.isEmpty()) {
//             res[index++] = minHeap.poll();
//         }

//         return res;
//     }
// }