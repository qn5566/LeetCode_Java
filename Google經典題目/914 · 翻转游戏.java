package Google經典題目;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i <= n - 2; i++){
            String pre = s.substring(0, i);
            String two = s.substring(i, i + 2);
            String post = s.substring(i + 2, n);
            if (two.equals("++")){
                ans.add(pre + "--" + post);
            }
        }
        return ans;
    }
}
