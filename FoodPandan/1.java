package FoodPandan;

/**
 * https://levelup.gitconnected.com/minimum-number-of-coins-that-must-be-reversed-to-achieve-alternating-sequence-of-heads-and-tails-632b72794964
 * @param A
 * @return
 */
class Solution {
    public int solution(int[] A) {
        int n = A.length, count1 = 0, count2 = 0;

        if(n > 0){
            for(int index = 0; index < n; index++){
                if(index % 2 == 0){
                    if(A[index] == 1)
                    count1+=1;
                    if(A[index] == 0)
                    count2+=1;
                }else{
                    if(A[index] == 0)
                    count1+=1;
                    if(A[index] == 1)
                    count2+=1;
                }
            }
        }
       return Math.min(count1,count2);
    }
}

/**
 * 英文解釋想法
 * My opinion is
 * 
 * sequence of alternating heads and tails
 * 
 * I can count all the values in the sequence at once according to 1 0 1 0 or 0 1 0 1 make statistics.
 * So using for loop to division % 2 can get remainder whether to divide
 * 
 * count1 is arrangement first type 1 0 1 0 
 * count2 is arrangement sec type 0 1 0 1 
 * 
 * 大於  more than the
 * 小於 less than
 */