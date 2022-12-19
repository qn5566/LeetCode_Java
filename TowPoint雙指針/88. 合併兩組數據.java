package TowPoint雙指針;

/**
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 题目描述：把归并结果存到第一个数组上。
 * 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
 * 也就是說從後面的0開始修改
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }

        while (index2 >= 0) {
            nums1[indexMerge--] = nums2[index2--];
        }

        // while (index2 >= 0) {
        // if (index1 < 0) {
        // nums1[indexMerge--] = nums2[index2--];
        // } else if (index2 < 0) {
        // nums1[indexMerge--] = nums1[index1--];
        // } else if (nums1[index1] > nums2[index2]) {
        // nums1[indexMerge--] = nums1[index1--];
        // } else {
        // nums1[indexMerge--] = nums2[index2--];
        // }
        // }
    }
}

/**
 * 另外如果沒有規定一定要從第二的組加回第一個的話
 * 一班做法是訂一個新的數組去做判斷
 */
class Solution_old {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            mergedArray[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }
        while (i < n) {
            mergedArray[k++] = nums1[j++];
        }
        return mergedArray;
    }
}
