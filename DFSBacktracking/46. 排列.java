package DFSBacktracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Backtracking（回溯）属于 DFS。
 * 
 * time : O(N!*N) N等於數組長
 * Space : O(n)
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * 
 * Input: nums = [1]
 * Output: [[1]]
 * DFS經典題目
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ans.add(nums[i]);
            }
            res.add(ans);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(res, nums, index + 1);
            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

// class Solution {
// public List<List<Integer>> permute(int[] nums) {
// int len = nums.length;
// List<List<Integer>> res = new ArrayList<>();
// if (len == 0)
// return res;

// // 記錄數據
// Deque<Integer> path = new ArrayDeque<>();
// boolean[] used = new boolean[len];
// dfs(nums, len, 0, path, used, res);
// return res;
// }

// private void dfs(int[] nums, int len, int depth, Deque<Integer> path,
// boolean[] used,
// List<List<Integer>> res) {
// if (depth == len) {
// res.add(new ArrayList<>());
// return;
// }

// for (int i = 0; i < len; i++) {
// if (used[i]) {
// continue;
// }
// path.addLast(nums[i]);
// used[i] = true;
// dfs(nums, len, depth + 1, path, used, res);
// path.removeLast();
// used[i] = false;
// }
// }
// }
