package DailyChallenge;

// =====================================================
// 2094. Finding 3-Digit Even Numbers
// =====================================================

import java.util.ArrayList;
import java.util.List;

public class FindingThreeDigitEvenNumbers_7 {

    public int[] findEvenNumbers(int[] digits){
        List<Integer> resList = new ArrayList<>();
        int[] freq = new int[10];

        for (int digit : digits ){
            freq[digit]++;
        }

        for (int num = 100; num < 1000; num+=2){
            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            freq[a]--;
            freq[b]--;
            freq[c]--;

            if(freq[a] >= 0 && freq[b] >= 0 && freq[c] >= 0 )
                resList.add(num);

            freq[a]++;
            freq[b]++;
            freq[c]++;
        }

        int[] res = new int[resList.size()];
        for (int i = 0 ; i < resList.size(); i++ ){
            res[i] = resList.get(i);
        }

        return res;
    }
}
