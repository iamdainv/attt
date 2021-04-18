package Rsa;

import Modulo.HaBacLuyThua;
import Modulo.Helper;

public class ElGamal {
    int q;
    int a;
    int xA;
    int k;
    int M;

    public ElGamal(int q, int a,int xA,int k, int m) {
        this.q = q;
        this.a = a;
        this.xA = xA;
        this.k = k;
        M = m;
    }

    private int yA(){
        return HaBacLuyThua.Modulo(a,xA,q);
    }

    private int[] PU(){
        int[] x = { q,a,yA() };
        return x;
    }

    private int[] BSendA(){
        int K = HaBacLuyThua.Modulo(yA(), k,q);
        int C1 = HaBacLuyThua.Modulo(a,k,q);
        int C2 = HaBacLuyThua.Modulo(K*M,1,q);
        return new int[]{C1,C2};
    }

    public void solve(){
        int[] C = this.BSendA();
        int K = HaBacLuyThua.Modulo(C[0],xA,q);
        int inverse_K =  Helper.modulo_inverse(K,q);
        int M = (C[1] * inverse_K) % 19;
        System.out.println("C1 = " + C[0] + " C2 = " + C[1]);
        System.out.println("K = " + K);
        System.out.println("K Inverse = " + inverse_K);
        System.out.println("M = " + M);
    }

    public static void main(String[] args) {
        ElGamal el = new ElGamal(19,10,5,6,17);
        el.solve();
    }
}
