package 綜合;

/**
 * 泰波拿契數(Tribonacci Number) 即把費波拿契數(Fibonacci Number) 的概念推廣至三個數
 * 統一算法
 */
class Solution {
    public int tribonacci(int n) {
        if (n <= 1)
            return n;
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tmp;
        }
        return t2;
    }
}
