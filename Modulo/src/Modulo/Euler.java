package Modulo;

public class Euler {



    public  int Euler(int a,int m, int n){
        int b1, amountA;

        if (Helper.coprime(a,n)){
            b1 = m % Helper.phi(n);
            return HaBacLuyThua.Modulo(a,b1,n);
        }else{
            amountA = (int)m / (Helper.phi(n) + 1);
            b1 = (m % (Helper.phi(n) + 1)) + amountA;
            return HaBacLuyThua.Modulo(a,b1,n);
        }

    }


    public static void main(String[] args) {
        Euler el = new Euler();
        System.out.println(el.Euler(11,9,20));
    }
}
