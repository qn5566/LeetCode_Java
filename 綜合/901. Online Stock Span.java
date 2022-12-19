package 綜合;

import java.util.Stack;

/**
 * array裡面的數比自己還要小的就+1
 * 
 * Input
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * Output
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * 
 * Explanation
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // return 1
 * stockSpanner.next(80); // return 1
 * stockSpanner.next(60); // return 1
 * stockSpanner.next(70); // return 2
 * stockSpanner.next(60); // return 1
 * stockSpanner.next(75); // return 4, because the last 4 prices (including
 * today's price of 75) were less than or equal to today's price.
 * stockSpanner.next(85); // return 6
 */
class StockSpanner {

    private Stack<int[]> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            count += stack.pop()[1];
        }
        stack.push(new int[] { price, count });
        return count;
    }
}
