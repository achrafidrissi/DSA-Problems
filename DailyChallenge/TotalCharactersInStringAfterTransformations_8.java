package DailyChallenge;

// =====================================================
// 3337. Total Characters in String After Transformations I
// =====================================================

public class TotalCharactersInStringAfterTransformations_8 {

    private static final int MOD = 1000000007;

    private int addMod (int a, int b){
        a += b;
        if(a >= MOD) a -= MOD;
        return a;
    }

    public int lengthAfterTransformations(String s, int t){

        int[] freq = new int[26];

        for (char c : s.toCharArray()){
            freq[c-'a']++;
        }

        while (t-- > 0) {
            int[] next = new int[26];
            for (int i = 0; i<26; i++){
                if(i<25)
                    next[i+1] = freq[i];
                else {
                    next[0] = freq[25];
                    next[1] = addMod(next[1], freq[25]);
                }
            }

            freq = next;
        }
        int result = 0;
        for (int num : freq){
            result = addMod(result, num);
        }

        return result;
    }
}
