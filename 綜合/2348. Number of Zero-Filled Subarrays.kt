計算正列裡面都是0的組合有幾種

ex [0],[0,0],[0,0,0]....

Example 1:

Input: nums = [1,3,0,0,2,0,0,4]
Output: 6
Explanation: 
There are 4 occurrences of [0] as a subarray.
There are 2 occurrences of [0,0] as a subarray.
There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
Example 2:

Input: nums = [0,0,0,2,0,0]
Output: 9
Explanation:
There are 5 occurrences of [0] as a subarray.
There are 3 occurrences of [0,0] as a subarray.
There is 1 occurrence of [0,0,0] as a subarray.
There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.

class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var ans = 0L
        var count = 0L

        for (i in nums.indices) {
            if (nums[i] == 0) {
                ++count
                ans += count
            } else {
                count = 0
            }
        }
        return ans
    }
}