package 綜合;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Input: start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1
 * 
 * Input: start = "AACCGGTT", end = "AAACGGTA", bank =
 * ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * Output: 2
 * 
 * Input: start = "AAAAACCC", end = "AACCCCCC", bank =
 * ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * Output: 3
 * 
 * 注意一次只能換一個
 * Output = 替換的次數
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String item : bank) {
            set.add(item);
        }

        if (!set.contains(end)) {
            return -1;
        }

        Queue<String> q1 = new LinkedList<>();
        q1.add(start);
        Queue<String> q2 = new LinkedList<>();
        q2.add(end);

        int steps = 0;
        while (q1.size() > 0 && q2.size() > 0) {
            Queue<String> nextQueue = new LinkedList<>();
            while (q1.size() > 0) {
                String cur = q1.poll();
                Iterator<String> pos = set.iterator();
                while (pos.hasNext()) {
                    String next = pos.next();
                    if (valid(cur, next)) {
                        if (q2.contains(next)) {
                            return steps + 1;
                        }

                        nextQueue.add(next);

                        // pos.remove();
                    }
                }
            }
            q1 = nextQueue;

            Queue<String> temp = q1;
            q1 = q2;
            q2 = temp;

            steps++;
        }
        return -1;
    }

    boolean valid(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff >= 2) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
