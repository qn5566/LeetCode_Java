package 滑動窗口;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalFruit(int[] fruits) {
        int max_fruits = 0;
        Set<Integer> s = new HashSet<>();
        int left = 0;

        for (int right = 0; right < fruits.length; right++) {
            // 當儲存的資料大於2筆,而且資料裡面沒有重複的資料時候
            if (s.size() >= 2 && !s.contains(fruits[right])) {
                // 刪除左邊最新的資料
                int lastFruit = fruits[right - 1];
                for (int j = right - 2; j >= 0; j--) {
                    // 判斷是否一樣的水果
                    if (fruits[j] != lastFruit) {
                        left = j + 1;
                        s.remove(fruits[j]);
                        break;
                    }
                }
            }
            // 加入新的
            s.add(fruits[right]);
            // 比較一下大小,如果新的資料有比較大在覆蓋做使用
            max_fruits = Math.max(max_fruits, right - left + 1);
        }
        return max_fruits;
    }
}
