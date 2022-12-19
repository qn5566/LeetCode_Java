package Google經典題目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 题目中有个限制条件，就是说不会有重叠产生，比如 "abc"，如果让在0位置上查找 "ab" 了，就不会让在1位置上查找 "bc"，这样的话，就可以从后往前开始查找替换，因为不会有重叠，所以后面替换了的字符不会影响到前面。
所以就可以将indexes按照降序排列，从前往后查找，从后往前替换即可。
 */
class Solution {
    /**
     * @param S:       a string
     * @param indexes: the index array
     * @param sources: the source array
     * @param targets: the target array
     * @return: the string after operation
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        // Write your code here.
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            sorted.add(new int[] { indexes[i], i });
        }
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind : sorted) {
            int i = ind[0], j = ind[1];
            String s = sources[j], t = targets[j];
            if (S.substring(i, i + s.length()).equals(s)) {
                S = S.substring(0, i) + t + S.substring(i + s.length());
            }
        }
        return S;
    }
}
