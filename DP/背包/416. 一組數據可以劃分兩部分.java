package DP.背包;

/**
 * 
 * 动态规划 Dynamic Programming 就是不二之选。定义一个一维的 dp 数组，其中 dp[i]
 * 表示原数组是否可以取出若干个数字，其和为i。那么最后只需要返回 dp[target] 就行了。初始化 dp[0] 为
 * true，由于题目中限制了所有数字为正数，就不用担心会出现和为0或者负数的情况。关键问题就是要找出状态转移方程了，需要遍历原数组中的数字，对于遍历到的每个数字
 * nums[i]，需要更新 dp 数组，既然最终目标是想知道 dp[target] 的 boolean 值，就要想办法用数组中的数字去凑出
 * target，因为都是正数，所以只会越加越大，加上 nums[i] 就有可能会组成区间 [nums[i], target]
 * 中的某个值，那么对于这个区间中的任意一个数字j，如果 dp[j - nums[i]] 为 true 的话，说明现在已经可以组成 j-nums[i]
 * 这个数字了，再加上 nums[i]，就可以组成数字j了，那么 dp[j] 就一定为 true。如果之前 dp[j] 已经为 true 了，当然还要保持
 * true，所以还要 ‘或’ 上自身，于是状态转移方程如下：
 * 
 * dp[j] = dp[j] || dp[j - nums[i]] (nums[i] <= j <= target)
 * 
 * 有了状态转移方程，就可以写出代码了，这里需要特别注意的是，第二个 for 循环一定要从 target 遍历到
 * nums[i]，而不能反过来，想想为什么呢？因为如果从 nums[i] 遍历到 target 的话，假如 nums[i]=1 的话，那么 [1,
 * target] 中所有的 dp 值都是 true，因为 dp[0] 是 true，dp[1] 会或上 dp[0]，为 true，dp[2] 会或上
 * dp[1]，为 true，依此类推，完全使的 dp 数组失效了，参见代码如下：
 * T = O(n*sum)
 * S = O(n*sum)
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for (int num : nums) { // 0-1 背包一个物品只能用一次
            for (int i = W; i >= num; i--) { // 从后往前，先计算 dp[i] 再计算 dp[i-num]
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }

    /**
     * 總和
     * 
     * @param nums
     * @return
     */
    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}