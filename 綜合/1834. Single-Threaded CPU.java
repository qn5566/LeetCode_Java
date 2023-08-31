package 綜合;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 */
class Solution {
    class Task {
        public int procTime;
        public int index;

        public Task(int procTime, int index) {
            this.procTime = procTime;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        final int n = tasks.length;

        int[][] A = new int[n][3];

        for (int i = 0; i < n; ++i) {
            A[i][0] = tasks[i][0];
            A[i][1] = tasks[i][1];
            A[i][2] = i;
        }

        int[] ans = new int[n];
        int ansIndex = 0;
        Queue<Task> minHeap = new PriorityQueue<>(
                (a, b) -> a.procTime == b.procTime ? a.index - b.index : a.procTime - b.procTime);
        int i = 0; // tasks' pointer
        long time = 0; // Current time

        Arrays.sort(A, Comparator.comparing(a -> a[0]));

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty())
                time = Math.max(time, (long) A[i][0]);
            while (i < n && time >= (long) A[i][0]) {
                minHeap.offer(new Task(A[i][1], A[i][2]));
                ++i;
            }
            // peek 查看最前面
            // poll 查看最前面並刪除
            final int procTime = minHeap.peek().procTime;
            final int index = minHeap.poll().index;
            time += procTime;
            ans[ansIndex++] = index;
        }

        return ans;
    }
}
