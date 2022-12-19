package Graph;

import java.util.Arrays;

/**
 * 本來一開始想用visited set 來做，但是其實這太浪費了，而且也無法include all case
 * （不是所有合理的edge都是 one visited, one unvisited，
 * 也是有最後才連起來的例子，如(1,2) (1,5) (3,4)(3,5)
 * 所以還是用union的概念來做最簡單，只要走過的都標記成tree origin 就可以了，
 * 比較tricky的就是怎麼標註這邊用的是一個nums array來標注是否有被visited過，
 * 一旦visited過就把值改成 tree origin的position，然後留nums[origin] -1來回傳統一值
 * （這邊就直接用position了）
 * 至於最後一行的return 判斷是判斷有沒有forest的，因為當run 過上面的for 迴圈後，
 * 我們可以確定這些由edge構成的是tree 沒錯，但是沒辦法保證不是forest ，
 * 而只要edges的數量是n-1 就可以保證一定是tree小於的情況就會是forest
 * （表示有edge 缺少使兩tree不相連）
 */
// Union Find 的方式
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1 && edges.length == 0){
            return true;
        }

        if(n < 1 || edges == null || edges.length != n-1){
            return false;
        }

        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        for(int[] pair : edges){
            int x = findorigin(nums, pair[0]);
            int y = findorigin(nums, pair[1]);
            if(x == y){
                return false;
            }
            nums[x] = y;
        }
        return true;

        // for (int index = 0; index < edges.length; index++) {
        //     int x = findorigin(nums, edges[index][0]);
        //     int y = findorigin(nums, edges[index][1]);
        //     if (x == y)
        //         return false;
        //     nums[y] = x;
        // }
        // return (edges.length == n - 1);
    }

    private int findorigin(int[] nums, int index){
        while(nums[index] != -1){
            index = nums[index];
        }
        return index;
    }
    // private int findorigin(int[] nums, int index) {
    //     if (nums[index] == -1)
    //         return index;
    //     return findorigin(nums, nums[index]);
    // }
}
