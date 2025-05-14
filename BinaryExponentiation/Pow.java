package BinaryExponentiation;

// =====================================================
// 50. Pow(x, n)
// =====================================================

public class Pow {
    public double myPow(double x, int n){

        long y = Math.abs((long) n);
        double result = 1;
        while (y > 0){
            if (y%2 == 0){
                result *= x;
            }
            x*=x;
            y/=2;
        }
        return n<0 ? (1/result) : result;
    }
}
