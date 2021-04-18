package Modulo;

public class Euler {
    private  int phi(int n){
        int result = 1;
        for (int i = 2; i < n; i++)
            if (coprime(i,n))
                result++;
        return result;
    }

    //số nguyên tố cùng nhau
    private  boolean coprime(int a,int b){
        return Helper.gcd(a, b) == 1;
    }

    public  int Euler(int a,int m, int n){
        int b1, amountA;

        if (coprime(a,n)){
            b1 = m % phi(n);
            return HaBacLuyThua.Modulo(a,b1,n);
        }else{
            amountA = (int)m / (phi(n) + 1);
            b1 = (m % (phi(n) + 1)) + amountA;
            return HaBacLuyThua.Modulo(a,b1,n);
        }

    }


    public static void main(String[] args) {
        Euler el = new Euler();
        System.out.println(el.Euler(11,9,20));
    }
}
