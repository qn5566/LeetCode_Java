package 綜合;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        for(int i = 1; i < colors.length(); i++){
            char c1 = colors.charAt(i);
            char c2 = colors.charAt(i-1);
        
        if(c1 == c2){
            res = res + Math.min(neededTime[i], neededTime[i - 1] );
            neededTime[i] = Math.max(neededTime[i], neededTime[i - 1] );
        }

        }

        return res;
    }
}
