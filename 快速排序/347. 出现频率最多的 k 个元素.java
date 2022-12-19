package 快速排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 桶排序方法
 * 
 * 设置若干个桶，每个桶存储出现频率相同的数。
 * 桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
 * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
 * 
 * 先用Map計算頻率
 * 在用List做排序
 * 最後從後向前遍歷
 * 可以取得第k大的數
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> eleFreq = new HashMap<>();
        for (int i : nums) {
            eleFreq.put(i, eleFreq.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1]; // need n+1 because if all numbers are same then the freq is
                                                          // 'n'

        for (Map.Entry<Integer, Integer> entry : eleFreq.entrySet()) {
            int n = entry.getKey();
            int f = entry.getValue();

            if (freq[f] == null)
                freq[f] = new ArrayList<>();

            freq[f].add(n);
        }

        int[] ans = new int[k];
        int c = 0;
        for (int i = freq.length - 1; i > 0 && c < k; i--) {
            if (freq[i] == null)
                continue;
            for (int num : freq[i]) {
                ans[c++] = num;
                if (c == k)
                    break;
            }
        }
        return ans;
    }
}

/**
 * 另外一種寫法
 */
class Solution_2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        // 先把nums 出現的次數存入 map
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }

        // 再把map的資料拉出來 List<Integer>
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // 再來求前k個頻率 所以從後遍歷到前
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }

        // 轉換取前值
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;
    }
}

// class Solution {
// public int[] topKFrequent(int[] nums, int k) {
// List<Integer> res = new ArrayList<>();

// HashMap<Integer, Integer> map = new HashMap<>();
// for (int num : nums) {
// map.put(num, map.getOrDefault(num, 0) + 1);
// }

// // 降冪 固定寫法
// PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b)
// -> (b.getValue() - a.getValue()));

// for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
// queue.offer(entry);
// }

// for (int i = 0; i < k; i++) {
// res.add(queue.poll().getKey());
// }

// int[] arr = new int[res.size()];
// for (int i = 0; i < arr.length; i++) {
// arr[i] = res.get(i);
// }

// return arr;
// }
// }
