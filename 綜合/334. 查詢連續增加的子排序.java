package 綜合;

/**
 * 有連續遞增的子排序數列查詢
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        
        for(int a : nums){
            if(m1 >= a){
                m1 = a;
            }else if(m2 >= a){
                m2 = a;
            }else {
                return true;
            }
        }
        return false;
    }
}