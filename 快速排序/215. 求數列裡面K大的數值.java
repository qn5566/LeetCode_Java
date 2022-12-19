package 快速排序;

import java.util.PriorityQueue;

/**
 * 这里排序的方向是从大往小排
 * 把大于中枢点的数字放到左半边，
 * 把小于中枢点的放在右半边，这样中枢点是整个数组中第几大的数字就确定了
 * 
 * 快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)
 */
class Solution_new {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        quickSort(nums, left, right);
        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int q = partition(nums, left, right);
        // 左邊排好
        quickSort(nums, left, q - 1);

        // 右邊排好
        quickSort(nums, q + 1, right);
    }

    // 分一半
    private int partition(int[] nums, int left, int right) {
        // 雖機挑選位置
        int pivot = left + (right - left) / 2;
        swap(nums, pivot, right);

        int l = left;
        for (int j = l; j < right; j++) {
            if (nums[j] <= nums[right]) {
                swap(nums, l, j);
                l = l + 1;
            }
        }
        swap(nums, l, right);
        return l;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

/**
 * 這也是快速排序法
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (true) {
            // pos + 1就是第几大数
            // pos就是位置，所以比第几大数少一个
            int pos = position(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
                // 加入求第四大数
                // 而此时pos = 4
                // pos + 1 > 4
                // right = 3
                // 这时，让然包括了结果
            } else if (pos + 1 > k) {
                // 答案在左邊 所以移動right
                right = pos - 1;
            } else {
                // 答案在右邊 所以移動left
                left = pos + 1;
            }
        }

    }

    // 回傳是第K大的數
    private int position(int[] nums, int left, int right) {
        int pivot = nums[left];
        // 防止 [1] 1 的問題
        int l = left + 1;
        int r = right;
        // 使得pivot左边的值都大于它，右边的值都小于它
        // 要使用 <=
        // 否则[2,1] 1这种情况会报错
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l, r);
                l++;
                r--;
            }
            // 跳过符合条件的值
            if (nums[l] >= pivot)
                l++;
            if (nums[r] <= pivot)
                r--;
        }

        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

/**
 * 堆 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
 */
class Solution_2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) // 维护堆的大小为 K
                pq.poll();
        }
        return pq.peek();
    }
}
