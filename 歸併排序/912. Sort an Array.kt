package 歸併排序;
/**
 * 這個 Kotlin 代碼使用了归并排序算法來排序整数数组。在這個算法中，我们将数组分成两个部分，对这两个部分进行递归排序，然后将它们合并在一起。
 *
 * 在 mergeSort 函数中，我们首先检查数组的左右指针是否重叠，如果是，则不需要排序。否则，我们计算数组的中间指针，并对左半部分和右半部分进行递归排序。最后，我们使用 merge
 * 函数将左半部分和右半部分合并。
 *
 * 在 merge 函数中，我们首先将左半部分和右半部分分别复制到两个临时数组中。然后，我们使用三个指针 i、j 和 k
 * 来遍历左半部分、右半部分和结果数组。我们比较左半部分和右半部分中的元素，并将较小的元素复制到结果数组中。最后，我们将剩余的元素复制到结果数组中。
 *
 * 在主函数中，我们创建了一个整数数组 nums，并使用 mergeSort 函数对它进行排序。最后，我们输出排序后的数组。
 *
 * 在這個解決方案中，我們使用了 LeetCode 的模板，創建了一個 Solution 類。這個類有一個名為 sortArray 的公共函數，它接受一個整數數組 nums
 * 作為輸入，並返回一個已排序的整數數組。
 *
 * 在 sortArray 函數中，我們首先使用 mergeSort 函数對整個數組進行排序。最後，我們返回排序後的數組。
 *
 * 在 mergeSort 函数中，我們首先檢查數組的左右指針是否重疊，如果是，則不需要排序。否則，我們計算數組的中間指針，並對左半部分和右半部分進行遞歸排序。最後，我們使用 merge
 * 函数將左半部分和右半部分合併。
 *
 * 在 merge 函数中，我們首先將左半部分和右半部分分別複製到兩個臨時數組中。然後，我們使用三個指針 i、j 和 k
 * 來遍歷左半部分、右半部分和結果數組。我們比較左半部分和右半部分中的元素，並將較小的元素複製到
 */
class Solution {
    fun sortArray(nums: IntArray): IntArray {
        mergeSort(nums, 0, nums.size - 1)
        return nums
    }

    fun mergeSort(nums: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }

        val middle = (left + right) / 2
        mergeSort(nums, left, middle)
        mergeSort(nums, middle + 1, right)
        merge(nums, left, middle, right)
    }

    fun merge(nums: IntArray, left: Int, middle: Int, right: Int) {
        val leftArray = nums.copyOfRange(left, middle + 1)
        val rightArray = nums.copyOfRange(middle + 1, right + 1)

        var i = 0
        var j = 0
        var k = left

        while (i < leftArray.size && j < rightArray.size) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++]
            } else {
                nums[k++] = rightArray[j++]
            }
        }

        while (i < leftArray.size) {
            nums[k++] = leftArray[i++]
        }

        while (j < rightArray.size) {
            nums[k++] = rightArray[j++]
        }
    }
}