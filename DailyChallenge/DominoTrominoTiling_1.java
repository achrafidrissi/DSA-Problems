package DailyChallenge;

// =====================================================
// 790. Domino and Tromino Tiling
// =====================================================

public class DominoTrominoTiling_1 {
    public int numTillings(int n){
        //The pattern used in that problem is Dynmamic Programming
        //Hint : Counting the number of ways
        final int MOD = 1000000007;
        if (n==0) return 1;
        if (n==1) return 1;
        if (n==2) return 2;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        long sum = dp[0];

        for (int i = 3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1] + 2 * sum) % MOD;
            sum = (sum + dp[i-2])%MOD;
        }
        return (int)dp[n];
    }
}