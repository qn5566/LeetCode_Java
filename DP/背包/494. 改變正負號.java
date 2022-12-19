package DP.背包;

/**
 * 该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。
 * 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
 * 1. sum(P) - sum(N) = target
 * 2. sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 * 3. 2 * sum(P) = target + sum(nums)
 * 因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
 */
class Solution_new {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

class Solution_DSF {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private int findTargetSumWays(int[] nums, int start, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums, start + 1, S + nums[start])
                + findTargetSumWays(nums, start + 1, S - nums[start]);
    }
}

/**
 * 
 * dp 作法
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-494-target-sum/
 * 
 * @param nums
 * @param d
 * @param S
 */
class Solution {
    private int ans;

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (final int num : nums)
            sum += num;
        if (sum < Math.abs(S)) // Math.abs(x)=|x|；如果参数是非负数，则返回该参数。如果参数是负数，则返回该参数的相反数。
            return 0;
        ans = 0;
        dfs(nums, 0, S);
        return ans;
    }

    private void dfs(int[] nums, int d, int S) {
        if (d == nums.length) {
            if (S == 0)
                ++ans;
            return;
        }
        dfs(nums, d + 1, S - nums[d]);
        dfs(nums, d + 1, S + nums[d]);
    }
}

class Solution_2 {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private int findTargetSumWays(int[] nums, int start, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums, start + 1, S + nums[start])
                + findTargetSumWays(nums, start + 1, S - nums[start]);
    }
}

/**
 * DP 做法但會爆
 */
class Solution_3 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}