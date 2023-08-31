这个计算公式是为了求解每个问题的最大得分。

questions[i][0] 是当前问题 i 的得分。
questions[i][1] 是当前问题 i 解决后无法解决的下一个问题的数量。
dp[i + 1] 是跳过当前问题 i 后能获得的最大总得分。
根据题目要求，我们需要在解决或跳过问题 i 后，选择能够获得最大总得分的方式。

如果我们解决问题 i，那么可以获得 questions[i][0] 的得分，
然后需要考虑接下来的问题。由于问题 i 解决后无法解决 questions[i][1] 个问题，
所以我们需要找到最远可以解决的问题的索引，即 i + questions[i][1] + 1，
取其与 n（问题数量）的较小值，确保不越界。然后，我们加上该问题的最优解
 dp[minOf(i + questions[i][1] + 1, n)]。
如果我们跳过问题 i，那么我们只需要考虑接下来的问题，即 dp[i + 1]。
综上所述，通过比较解决问题 i 和跳过问题 i 后的最大得分，
选择其中较大的值作为 dp[i] 的值。这样就可以逐步计算出每个问题的最大得分，
并最终得到整个考试的最大得分。


class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        val n = questions.size
        val dp = LongArray(questions.size + 1)
        for (i in questions.size - 1 downTo 0) {
            dp[i] = maxOf(questions[i][0] + dp[minOf(i + questions[i][1] + 1, n)], dp[i + 1])
        }
        return dp[0]
    }
}