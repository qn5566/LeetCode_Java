package 綜合;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1)
            return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int item[] : edges) {
            if (!map.containsKey(item[0]))
                map.put(item[0], new LinkedList<>());

            if (!map.containsKey(item[1]))
                map.put(item[1], new LinkedList<>());

            map.get(item[0]).add(item[1]);
            map.get(item[1]).add(item[0]);
        }

        queue.add(source);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (set.contains(current))
                continue;
            set.add(current);

            List<Integer> neighbors = map.get(current);

            for (int item : neighbors) {
                if (item == destination)
                    return true;
                queue.add(item);
            }
        }

        return false;
    }
}