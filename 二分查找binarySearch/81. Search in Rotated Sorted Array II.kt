搜索旋轉排序數組 II 是一個搜索問題，該數組可能包含重複的元素。目標是在給定的旋轉排序數組中，判斷特定的目標元素是否存在。
這個問題的挑戰在於，由於數組中可能存在重複的元素，無法單純地使用二分查找進行搜索。因為存在重複的元素，可能會導致二分查找的區間不再有序，使得無法確定哪一部分是有序的。

在這個解法中，我們使用了變種的二分查找算法。我們根據數組的性質，對不同情況進行判斷：

如果 nums[mid] == target，則返回 true，表示已經找到目標元素。
如果 nums[left] == nums[mid] == nums[right]，無法確定哪一部分有序，我們將左指針往右移，右指針往左移。
如果 nums[left] <= nums[mid]，表示左半部分有序。在這種情況下，我們可以根據 target 是否位於左半部分的有序區間來調整指針的位置。
如果 nums[left] > nums[mid]，表示右半部分有序。在這種情況下，我們可以根據 target 是否位於右半部分的有序區間來調整指針的位置。
綜合以上情況，我們可以進行適當的指針移動，最終判斷目標元素是否存在於數組中。

class Solution {
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0
        var right = nums.size - 1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] == target) {
                return true
            }
            
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++
                right--
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        
        return false
    }
}
