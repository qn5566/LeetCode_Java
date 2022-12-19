package DFSBacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 
 * 這題是有重複的數組
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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

        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            if (visited.add(nums[index])) {
                dfs(res, nums, index + 1);
            }

            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
