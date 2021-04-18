package Modulo;

public class Helper {
    public  static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    //số nguyên tố cùng nhau
    static boolean coprime(int a,int b){
        return Helper.gcd(a, b) == 1;
    }


    static int phi(int n){
        int result = 1;
        for (int i = 2; i < n; i++)
            if (coprime(i,n))
                result++;
        return result;
    }

    public static  boolean isPrime(int n){
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int modulo_inverse(int a, int c){

        for(int i = 1 ; i < c; i++){
            if ((a * i) % c == 1){
                return i;
            }
        }
        return -1;
    }

    static boolean isCanNguyenThuy(int a,int n){
        int m = phi(n);
        if (1 == HaBacLuyThua.Modulo(a,m,n)){
            for (int i = 1; i < m; i++) {
                if (m % i == 0) {
                    if (1 == HaBacLuyThua.Modulo(a, i, n)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
