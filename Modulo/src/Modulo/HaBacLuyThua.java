package Modulo;

public class HaBacLuyThua {
    //tinh modulo bang cach ha bac luy thua

        public static int  Modulo(int a,int m,int n){
            boolean[] isDu = new boolean[100];
            int k = 1;
            while (m > 3) {
                if (m % 2 == 0) {
                    m /= 2;
                    isDu[k] = false;
                } else {
                    m = (m - 1) / 2;
                    isDu[k] = true;
                }
                k++;
            }
            int var = ((int) Math.pow(a, m)) % n;
            for (int i = k - 1; i > 0; i--) {
                if (isDu[i]) {
                    var = (var * var * a) % n;
                } else {
                    var = (var * var) % n;
                }
            }
            return var;
        }

    public static void main(String[] args) {
        System.out.println(Modulo(10,100,17));
    }
}
