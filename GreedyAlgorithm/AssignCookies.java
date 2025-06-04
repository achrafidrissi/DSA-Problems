package GreedyAlgorithm;

// =====================================================
// 455. Assign Cookies
// =====================================================

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s){

        if(s.length == 0 || g.length == 0)
            return 0;

        int countHappy = 0, i = 0, j = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while ( i < g.length && j < s.length ){
            if(s[j] >= g[i]){
                countHappy++;
                i++;
                j++;
            }else {
                j++;
            }
        }

        return countHappy;
    }
}
