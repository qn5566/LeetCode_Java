package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        Map<String, List<String>> graph = constructGraph(wordList);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.add(beginWord);

        int cost = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return cost;
                }

                for (String neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            cost++;
        }

        return 0;
    }

    private Map<String, List<String>> constructGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        int n = wordList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String w1 = wordList.get(i);
                String w2 = wordList.get(j);
                if (oneChangeAway(w1, w2)) {
                    graph.computeIfAbsent(w1, k -> new ArrayList<>()).add(w2);
                    graph.computeIfAbsent(w2, k -> new ArrayList<>()).add(w1);
                }
            }
        }
        return graph;
    }

    private boolean oneChangeAway(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (c1 != c2) {
                diff++;
            }
        }
        return diff == 1;
    }
}
