package DynamicProgramming;

// =====================================================
// 70. Climbing Stairs
// =====================================================

public class ClimbingStairs {
    public int climbStairs(int n){
        int first = 1, second = 1;
        for(int i = 2; i<=n; i++){
            int temp = second;
            second = first+second;
            first = temp;
        }
        return second;
    }
}
