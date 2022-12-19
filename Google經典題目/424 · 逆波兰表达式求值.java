package Google經典題目;

/**
 * 时间复杂度：O(n)O(n)，其中 nn 是数组 tokens 的长度。需要遍历数组
 * tokens 一次，计算逆波兰表达式的值。
 * 
 * 空间复杂度：O(n)O(n)，其中 nn 是数组tokens 的长度。需要创建长度为n+1/2的数组模拟栈操作。
 */
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
