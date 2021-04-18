package Modulo;

public class Fermat {
    public static int solve(int a,int m,int p){
            int b;
            if (Helper.isPrime(p) && a > 0){
                b = m % (p - 1);
                return HaBacLuyThua.Modulo(a,b,p);
            }
            return 1;
    }

    public static void main(String[] args) {
        System.out.println(solve(15,17,19));
    }
}
