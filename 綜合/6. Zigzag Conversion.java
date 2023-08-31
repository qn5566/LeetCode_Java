package 綜合;

/**
 * 文字排列從上到下
 * 再由下到上 (斜的上去)
 * 
 * 
 * ex :
 * "PAYPALISHIRING"
 * P A H N
 * A P L S I I G
 * Y I R
 * 
 * Ans: "PAHNAPLSIIGYIR"
 */
class Solution {
    public String convert(String s, int numRows) {
        // 第二種方法
        // Base conditions
        if (s == null || s.isEmpty() || numRows <= 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        // Resultant string
        StringBuilder result = new StringBuilder();
        // Step size
        int step = 2 * numRows - 2;
        // Loop for each row
        for (int i = 0; i < numRows; i++) {
            // Loop for each character in the row
            for (int j = i; j < s.length(); j += step) {
                result.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && (j + step - 2 * i) < s.length()) {
                    result.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        return result.toString();

        // char[] c = s.toCharArray();
        // int len = c.length;
        // StringBuilder[] sb = new StringBuilder[numRows];
        // for (int i = 0; i < sb.length; i++) {
        //     sb[i] = new StringBuilder();
        // }

        // int idx = 0;
        // while (idx < len) {
        //     for (int i = 0; i < numRows && idx < len; i++) {
        //         sb[i].append(c[idx++]);
        //     }
        //     for (int i = numRows - 2; i >= 1 && idx < len; i--) {
        //         sb[i].append(c[idx++]);
        //     }
        // }

        // for (int i = 1; i < sb.length; i++) {
        //     sb[0].append(sb[i]);
        // }

        // return sb[0].toString();
    }
}
