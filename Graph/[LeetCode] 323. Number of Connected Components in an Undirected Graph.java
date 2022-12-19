package Graph;

import java.util.Arrays;

class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = n;

        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        for (int[] pair : edges) {
            int x = findorigin(nums, pair[0]);
            int y = findorigin(nums, pair[1]);
            if (x != y) {
                nums[x] = y;
                res--;
            }

        }
        return res--;

        // for (int index = 0; index < edges.length; index++) {
        // int x = findorigin(nums, edges[index][0]);
        // int y = findorigin(nums, edges[index][1]);
        // if (x == y)
        // return false;
        // nums[y] = x;
        // }
        // return (edges.length == n - 1);
    }

    private int findorigin(int[] nums, int index) {
        while (nums[index] != -1) {
            index = nums[index];
        }
        return index;
    }
}