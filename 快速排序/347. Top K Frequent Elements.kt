
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // 計算每個元素的頻率
        val freqMap = HashMap<Int, Int>()
        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }
        
        // 使用最小堆保存頻率最高的 K 個元素
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        for ((num, freq) in freqMap) {
            minHeap.offer(num to freq)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        
        // 將最小堆中的元素轉為結果數組
        val result = IntArray(k)
        var index = 0
        while (minHeap.isNotEmpty()) {
            result[index] = minHeap.poll().first
            index++
        }
        
        return result
    }
}
