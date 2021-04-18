package Rsa;

import Modulo.HaBacLuyThua;
import Modulo.Helper;

public class Rsa {

    int p;
    int q;
    int e;

    public Rsa(int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.e = e;
    }

    public int n(){
        return  p*q;
    }

    public int d(){
        return Helper.modulo_inverse(e,phi());
    }

    public int phi(){
        return  (p - 1) * (q - 1);
    }

    public int[] PU(){
        int[] a = {e,n()};

        return a;
    }



    public int[] PR(){
        int[] a = {d(),n()};
        return a;
    }

    public int BEncryptM(int M){
        return HaBacLuyThua.Modulo(M,e,n());
    }

    public int ADecryptM(int C){
        return HaBacLuyThua.Modulo(C,d(),n());
    }

    public int AEncryptM(int M){
        return HaBacLuyThua.Modulo(M,e,n());
    }

    public int BDecryptM(int C){
        return HaBacLuyThua.Modulo(C,d(),n());
    }

    public void solve1(){
        int M = 88;
        int C = BEncryptM(M);

        int[] PU = PU();
        int[] PR = PR();
        System.out.println("Ba");
        System.out.println("PU={" + PU[0] + "," + PU[1] + "}\n");
        System.out.println("PR={" + PR[0] + "," + PR[1] + "}\n");

        System.out.println("M = " + M);
        System.out.println("B Encrypt M = " + C);
        System.out.println("A Decrypt C = " + ADecryptM(C));
    }

    public void solve2(){
        int M = 88;
        int C = AEncryptM(M);
        int[] PU = PU();
        int[] PR = PR();

        System.out.println("An");
        System.out.println("PU={" + PU[0] + "," + PU[1] + "}\n");
        System.out.println("PR={" + PR[0] + "," + PR[1] + "}\n");
        System.out.println("M = " + M);
        System.out.println("A Encrypt M = " + C);
        System.out.println("B Decrypt C = " + BDecryptM(C));
    }

    public static void main(String[] args) {
        Rsa r = new Rsa(17,11,7);
        r.solve1();
        r.solve2();

    }

}
