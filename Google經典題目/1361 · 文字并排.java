package Google經典題目;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据题干描述的贪心算法，对于每一行，我们首先确定最多可以放置多少单词，这样可以得到该行的空格个数，从而确定该行单词之间的空格个数。
 * 
 * 根据题目中填充空格的细节，我们分以下三种情况讨论：
 * 
 * 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格；
 * 当前行不是最后一行，且只有一个单词：该单词左对齐，在行末填充空格；
 * 当前行不是最后一行，且不只一个单词：设当前行单词数为 \textit{numWords}numWords，空格数为
 * \textit{numSpaces}numSpaces，我们需要将空格均匀分配在单词之间，则单词之间应至少有
 * \textit{avgSpaces}=\Big\lfloor\dfrac{\textit{numSpaces}}{\textit{numWords}-1}\Big\rflooravgSpaces=⌊
 * numWords−1
 * numSpaces
 * ​
 * ⌋
 * 个空格，对于多出来的
 * \textit{extraSpaces}=\textit{numSpaces}\bmod(\textit{numWords}-1)extraSpaces=numSpacesmod(numWords−1)
 * 个空格，应填在前 \textit{extraSpaces}extraSpaces 个单词之间。因此，前
 * \textit{extraSpaces}extraSpaces 个单词之间填充 \textit{avgSpaces}+1avgSpaces+1
 * 个空格，其余单词之间填充 \textit{avgSpaces}avgSpaces 个空格。
 * 
 * 时间复杂度：O(m)O(m)，其中 mm 是数组 \textit{words}words 中所有字符串的长度之和。
 * 空间复杂度：O(m)O(m)。
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int right = 0, n = words.length;
        while (true) {
            int left = right; // 当前行的第一个单词在 words 的位置
            int sumLen = 0; // 统计这一行单词长度之和
            // 循环确定当前行可以放多少单词，注意单词之间应至少有一个空格
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // 当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
            if (right == n) {
                StringBuffer sb = join(words, left, n, " ");
                sb.append(blank(maxWidth - sb.length()));
                ans.add(sb.toString());
                return ans;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            // 当前行只有一个单词：该单词左对齐，在行末填充剩余空格
            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                ans.add(sb.toString());
                continue;
            }

            // 当前行不只一个单词
            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1))); // 拼接额外加一个空格的单词
            sb.append(blank(avgSpaces));
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces))); // 拼接其余单词
            ans.add(sb.toString());
        }
    }

    // blank 返回长度为 n 的由空格组成的字符串
    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }

    // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
    public StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }
}
