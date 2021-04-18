package Modulo;

public class Logarithm {
    public static int logarithmRoiRac(int a, int b, int n)
    {
        for (int i = 1; i < n; i++)
        {
            if (b == HaBacLuyThua.Modulo(a, i, n))
            {
                return i;
            }
        }
        return -1;
    }
}
