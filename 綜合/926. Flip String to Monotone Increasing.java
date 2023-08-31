package 綜合;

/**
 * 需要複習
 */
class Solution {
    public int minFlipsMonoIncr(String s) {
         int n = s.length();
  // calculate prefix[] and suffix[]
  int[] prefix = new int[n];
  int[] suffix = new int[n];
  prefix[0] = s.charAt(0) == '1' ? 1 : 0;
  suffix[n - 1] = s.charAt(n - 1) == '0' ? 1 : 0;
  for (int i = 1, j = n - 2; i < n; ++i, --j) {
    prefix[i] = prefix[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
    suffix[j] = suffix[j + 1] + (s.charAt(j) == '0' ? 1 : 0);
  }
  // calculate the count
  int minCount = Integer.MAX_VALUE;
  for (int k = -1; k <= n - 1; ++k) {
    // 0: [0, k], 1: [k+1, n-1]
    int left = (k == -1) ? 0 : prefix[k];
    int right = (k + 1 == n) ? 0 : suffix[k + 1];
    minCount = Math.min(minCount, left + right);
  }
  return minCount;
    }
}
