package Google經典題目;

/**
 * 描述
 * 给定一个单词序列，检查它是否构成一个有效单词方阵。
 * 一个有效的单词方阵应满足以下条件：对于满足0≤k<max(numRows numColumns)的k，第k行和第k列对应的字符串应该相同,。
 * 输入:
 * [
 * "abcd",
 * "bnrt",
 * "crmy",
 * "dtye"
 * ]
 * 输出: true
 * 解释:
 * 第一行和第一列都是“abcd”。
 * 第二行和第二列都是“bnrt”。
 * 第三行和第三列都是“crmy”。
 * 第四行和第四列都是“dtye”。
 * 
 * 因此，这是一个有效的单词广场.
 */
class Solution {
    /**
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        // write your code here
        if (words.length != words[0].length())
            return false;
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                if (j >= words.length || i >= words[j].length() || words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
