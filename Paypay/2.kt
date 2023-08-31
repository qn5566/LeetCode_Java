Given an array of integers a, your task is to find how many of its contiguous subarrays of length m contain a pair of integers with a sum equal to k.

More formally, given the array a, your task is to count the number of indices 0 ≤ i ≤ a.length - m such that a subarray [a[i], a[i + 1], ..., a[i + m - 1]] contains at least one pair (a[s], a[t]), where:

s ≠ t
a[s] + a[t] = k

這邊有url 
https://leetcode.com/discuss/interview-question/1581706/codesignal-practice-test


fun solution(a: MutableList<Int>, m: Int, k: Int): Int {
    val map = mutableMapOf<Int, Int>()
    var ans = 0
    val set = mutableSetOf<Long>()

    // 建立一開始 m 個數字的哈希表
    for (i in 0 until m) {
        val num = a.getOrNull(i) ?: break
        if (map.containsKey(k - num)) {
            val cur = num.toLong() * (k - num).toLong()
            if (!set.contains(cur)) set.add(cur)
        }
        map[num] = map.getOrDefault(num, 0) + 1
    }
    if (set.isNotEmpty()) ans++

    // 滑動視窗
    var left = 0
    for (i in m until a.size) {
        // 更新左邊界的數字在哈希表中的出現次數
        val leftNum = a[left]
        if (map[leftNum]!! > 1) {
            map[leftNum] = map[leftNum]!! - 1
            if (leftNum == k - leftNum && map[leftNum] == 1) {
                val cur = leftNum.toLong() * (k - leftNum).toLong()
                set.remove(cur)
            }
        } else {
            if (map.containsKey(k - leftNum)) {
                val cur = leftNum.toLong() * (k - leftNum).toLong()
                set.remove(cur)
            }
            map.remove(leftNum)
        }
        left++

        // 更新右邊界的數字在哈希表中的出現次數
        val rightNum = a[i]
        if (map.containsKey(k - rightNum)) {
            val cur = rightNum.toLong() * (k - rightNum).toLong()
            if (!set.contains(cur)) set.add(cur)
        }
        if (set.isNotEmpty()) ans++
        map[rightNum] = map.getOrDefault(rightNum, 0) + 1
    }
    return ans
}


kotlin
Copy code
fun solution(a: MutableList<Int>, m: Int, k: Int): Int {
這是 Kotlin 的函數宣告，名稱是 solution，接收三個引數：

a 是整數的可變列表，即一個 List<Int>。
m 是一個整數。
k 是一個整數。
回傳值是一個整數。

python
Copy code
    return a.windowed(m).count { it.sum() == k || (k - it.sum()) in it && (k - it.sum()) != it.sum() }
}
這一行是函數的實作部分。解釋如下：

windowed 函數將列表中的元素按照指定大小，分割成多個子列表。例如，若 m 為 3，a 為 [1, 2, 3, 4, 5]，則 windowed(m) 的結果為 [[1, 2, 3], [2, 3, 4], [3, 4, 5]]。
count 函數是 Kotlin 的擴充函數，計算符合指定條件的元素數量。此處，它統計了所有子列表中滿足以下條件的元素個數：
子列表元素總和等於 k。
子列表中有兩個不同的元素，其和等於 k。
最終，count 函數的回傳值即為函數 solution 的回傳值。