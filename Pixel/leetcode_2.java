package Pixel;

/**
 * Write a function:
 * 
 * class Solution {
 * public int solution(int A, int B);
 * }
 * 
 * that, given two non-negative integers A and B, returns the number of bits set
 * to 1 in the binary representation of the number A * B.
 * 
 * For example, given A = 3 and B = 7 the function should return 3, because the
 * binary representation of A * B = 3 * 7 = 21 is 10101 and it contains three
 * bits set to 1.
 * 
 * Assume that: A and B are integers within the range [0..100,000,000].
 * 
 * In your solution, focus on correctness. The performance of your solution will
 * not be the focus of the assessment.
 * 
 * 
 * 即，給定兩個非負整數 A 和 B，返回在數字 A * B 的二進製表示中設置為 1 的位數。
 * 例如，給定 A = 3 和 B = 7，函數應該返回 3，因為 A * B = 3 * 7 = 21 的二進製表示是 10101，它包含三個設置為 1
 * 的位。
 * 
 * 假設：A 和 B 是 [0..100,000,000] 範圍內的整數。
 * 在您的解決方案中，關注正確性。 您的解決方案的性能將不是評估的重點。
 */

class leetcode_2 {
    public int solution(int A, int B) {
        Integer tmepCa = A * B;
        // 假如 3 * 7
        // 2進位寫法
        String binaryParse = Integer.toString(tmepCa, 2);
        // 答案是 10101

        // 分別拉出array
        String[] binArr = binaryParse.split("");
        int result = 0;

        // 等於1的就+result
        for (String a : binArr) {
            if (a.equals("1")) {
                result++;
            }
        }
        return result;
    }
}
