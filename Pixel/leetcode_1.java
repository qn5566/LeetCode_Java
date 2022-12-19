package Pixel;

/**
 * Given a string S consisting of N letters a and b. In one move you can replace
 * one letter by the other (a by b or b by a).
 * Write a function solution that given such a string S, returns the minimum
 * number of moves required to obtain a string containing no instances of three
 * identical consecutive letters.
 * #Example 1:
 * Input: "baaaaa"
 * Output: 1
 * Explanation: The string without three identical consecutive letters which can
 * be obtained is one move is "baabaa".
 * 
 * Example 2:
 * Input: "baaabbaabbba"
 * Output: 2
 * Explanation: There are four valid strings obtainable in two moves, for
 * example "bbaabbaabbaa".
 * 
 * Example 3:
 * Input: "baabab"
 * Ouput: 0
 * 
 * Assumptions:
 * N is an integer within the range [0, ..200,000];
 * string S consists of only characteres a and b*
 * 
 * 給定一個由 N 個字母 a 和 b 組成的字符串 S。 在一個動作中，您可以將一個字母替換為另一個（a 替換為 b 或 b 替換為 a）。
 * 編寫一個函數解決方案，給定這樣的字符串 S，返回獲得不包含三個相同連續字母實例的字符串所需的最小移動次數
 * 
 * T : O(n)
 * O : 1
 *
 */

class leetcode_1 {
    public int solution(String S) {
        // 邊界條件判斷
        if (S == null || S.isEmpty()) {
            return 0;
        }
        // 小於3不用換
        if (S.length() < 3)
            return 0;

        StringBuilder s = new StringBuilder(S);
        int answer = 0;
        int tempCur = 1;
        for (int i = 1; i < s.length(); i++) {
            // 判斷如果不一樣的話就重新計算
            if (s.charAt(i) != s.charAt(i - 1)) {
                tempCur = 1;
            } else {
                tempCur++;
            }

            // 要替換了
            if (tempCur == 3) {
                // 這是最後一個字元的情況，是的話直接換
                if (i == s.length() - 1) {
                    answer++;
                    break;
                    // 檢查下一個是不是也是一樣，如果後面是一樣的話可以直接換
                } else if (s.charAt(i + 1) == s.charAt(i)) {
                    answer++;
                    if (s.charAt(i) == 'a') {
                        s.setCharAt(i, 'b');
                    } else {
                        s.setCharAt(i, 'a');
                    }
                } else {
                    answer++;
                    // 下一個不一樣 所以替換上一個，因為直接換的話又會跟後面的一樣
                    if (s.charAt(i) == 'a') {
                        s.setCharAt(i - 1, 'b');
                    } else {
                        s.setCharAt(i - 1, 'a');
                    }
                }
                tempCur = 1;
            }
        }
        return answer;
    }
}
