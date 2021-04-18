package Modulo;

public class SoDuTrungHoa {



    static int ChinesRemainder(int[] num, int[] rem,
                        int k)
    {
        int x = 1;
        while (true)
        {
            int j;
            for (j = 0; j < k; j++)
                if (x % num[j] != rem[j])
                    break;
            if (j == k)
                return x;
            x++;
        }

    }

    public static void main(String[] args) {

        int[] num = {17,19};
        int[] rem = {16,5};
        int k = num.length;
        System.out.println("x is " + ChinesRemainder(num, rem, k));
        System.out.println(Helper.modulo_inverse(6,13));
    }
}
