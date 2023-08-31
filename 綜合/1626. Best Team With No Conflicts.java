package 綜合;

import java.util.Arrays;

/**
 * ex1:
 * Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * Output: 34
 * Explanation: You can choose all the players.
 * 
 * ex2:
 * Input: scores = [4,5,6,5], ages = [2,1,2,1]
 * Output: 16
 * Explanation: It is best to choose the last 3 players. Notice that you are
 * allowed to choose multiple people of the same age.
 * 
 * ex3:
 * Input: scores = [1,2,3,5], ages = [8,9,10,1]
 * Output: 6
 * Explanation: It is best to choose the first 3 players.
 */
class Player {
    public int age;
    public int score;

    public Player(int age, int score) {
        this.age = age;
        this.score = score;
    }
};

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        final int n = scores.length;
        Player[] players = new Player[n];
        // dp[i] := max score of choosing players[0..i] w/ players[i] being selected
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i)
            players[i] = new Player(ages[i], scores[i]);

        Arrays.sort(players, (a, b) -> a.age == b.age ? b.score - a.score : b.age - a.age);

        for (int i = 0; i < n; ++i) {
            // For each player, we choose it first
            dp[i] = players[i].score;
            // players[j].age >= players[i].age since we sort in descending order
            // So we only have to check that
            // players[j].score >= players[i].score
            for (int j = 0; j < i; ++j)
                if (players[j].score >= players[i].score)
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
