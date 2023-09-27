
"Sort Colors" 问题是经典的荷兰国旗问题，通常使用三路快速排序的思想来解决。
该问题的目标是按红、白、蓝的顺序排序包含红色、白色和蓝色元素的数组。

以下是 Kotlin 中解决 "Sort Colors" 问题的代码示例：

fun sortColors(nums: IntArray) {
    var low = 0  // 用于维护红色区域的右边界
    var high = nums.size - 1  // 用于维护蓝色区域的左边界
    var current = 0  // 用于遍历数组

    while (current <= high) {
        when {
            nums[current] == 0 -> {
                // 当前元素是红色，交换到红色区域
                swap(nums, low, current)
                low++
                current++
            }
            nums[current] == 2 -> {
                // 当前元素是蓝色，交换到蓝色区域
                swap(nums, current, high)
                high--
            }
            else -> {
                // 当前元素是白色，不需要交换，直接前进
                current++
            }
        }
    }
}

fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

这段代码使用了三个指针：low、current 和 high，分别用于维护红色、白色和蓝色区域的边界。通过不断交换元素，将数组按指定顺序排序。
使用上述代码，你可以将包含 0、1 和 2 的数组按照红、白、蓝的顺序进行排序。
