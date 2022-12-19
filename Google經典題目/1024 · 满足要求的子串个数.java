package Google經典題目;

/**
 * 定义 nxtPos[n][26], 其中 nxtPos[i][j] 表示串S的第i个位置起, 下标最靠前的字符 j + 'a' 的位置.
 * 
 * 借助 nxtPos 数组我们可以在 O(word.length) 的时间内判断出 word 是否 S 的子序列.
 * 
 * 而我们对 S 进行一次遍历就可以求出 nxtPos 数组.
 */
class Solution {
    /**
     * @param S:     a string
     * @param words: a dictionary of words
     * @return: the number of words[i] that is a subsequence of S
     */
    public int numMatchingSubseq(String S, String[] words) {
        int n = S.length();

        int[][] nxtPos = new int[n][26];

        for (int i = 0; i < 26; i++)
            nxtPos[n - 1][i] = -1;

        for (int i = n - 1; i >= 0; i--) {
            nxtPos[i][S.charAt(i) - 'a'] = i;
            if (i == 0) {
                break;
            }
            for (int j = 0; j < 26; j++)
                nxtPos[i - 1][j] = nxtPos[i][j];
        }

        int ans = 0;
        for (String word : words) {
            if (isSubseq(word, nxtPos)) {
                ans++;
            }
        }

        return ans;
    }

    public boolean isSubseq(String word, int[][] nxtPos) {
        int lenw = word.length();
        int lens = nxtPos.length;
        int i, j;
        for (i = 0, j = 0; i < lenw && j < lens; i++, j++) {
            j = nxtPos[j][word.charAt(i) - 'a'];
            if (j < 0) {
                return false;
            }
        }
        return i == lenw;
    }
}