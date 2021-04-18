package Rsa;

import Modulo.HaBacLuyThua;
import Modulo.Helper;

public class DiffieHellman {
    int a;
    int q;
    int xA;

    public DiffieHellman(int a, int q, int xA, int xB) {
        this.a = a;
        this.q = q;
        this.xA = xA;
        this.xB = xB;
    }

    int xB;

    public int yA(){
        return HaBacLuyThua.Modulo(a,xA,q);
    }

    public int yB(){
        return HaBacLuyThua.Modulo(a,xB,q);
    }

    public int kA(){
        return HaBacLuyThua.Modulo(yB(),xA,q);
    }

    public int kB(){
        return HaBacLuyThua.Modulo(yA(),xB,q);
    }

    public void Solve()
    {
        System.out.println("yA = " + yA());
        System.out.println("yB = " + yB());
        System.out.println("Key by A = " + kA());
        System.out.println("Key by B = " + kB());

    }

    public static void main(String[] args) {
        DiffieHellman dh = new DiffieHellman(3,353,97,233);

        dh.Solve();
    }

}
