import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BricksGame {
    int[] num;
    BigInteger[] f;
    int n;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BricksGame sol1 = new BricksGame();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            n = sc.nextInt();
            num = new int[n];
            f = new BigInteger[n];
            for (int i = 0; i < n ; i++) {
                num[i] = sc.nextInt();
                f[i] = BigInteger.valueOf(-1);
            }
            if (n ==1) {
                System.out.println(num[n-1]);
                continue;
            }
            if (n ==2) {
                System.out.println(num[n-1] + num[n-2]);
                continue;
            }
            
            if (n ==3) {
                System.out.println(num[n-1] + num[n-2] + num[n-3]);
                continue;
            }
            f[n-1] = new BigInteger(num[n-1] + "");
            f[n-2] = new BigInteger(num[n-1] + num[n-2] + "");
            f[n-3] = new BigInteger(num[n-1] + num[n-2] + num[n-3] + "");
            System.out.println(process2(0));
        }
    }
    public BigInteger process2(int index) {
        if (index >= n )
            return BigInteger.ZERO;
        if (f[index].intValue() != -1)
            return f[index];
        BigInteger a = BigInteger.ZERO;
        a = new BigInteger(num[index] + "");
        if (index + 1 < (n-3))
            a = a.add(min(process2(index + 2), process2(index + 3), process2(index + 4)));
        
        BigInteger b = BigInteger.ZERO;
        b = new BigInteger(num[index] + num[index + 1] + "");
        if (index + 2 < n-3) 
            b = b.add(min(process2(index + 3), process2(index + 4), process2(index + 5)));
        
        BigInteger c = BigInteger.ZERO;
        c = new BigInteger(num[index] + num[index + 1] + num[index + 2] + "");
        if (index + 3 < n-3)
            c = c.add(min(process2(index + 4), process2(index + 5), process2(index + 6)));
        
        f[index] = max (a, b, c);
        //System.out.println("Test " + index + " " + f[index] + " " + a + " "+ b + " " + c);
        return f[index];
    }
    public BigInteger max(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger ans = a;
        if (b.compareTo(a) >= 0 && b.compareTo(c) >= 0)
            ans = b;
        if (c.compareTo(b) >= 0 && c.compareTo(a) >= 0)
            ans = c;
        return ans;
    }
    public BigInteger min(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger ans = a;
        if (b.compareTo(a) <= 0 && b.compareTo(c) <= 0)
            ans = b;
        if (c.compareTo(b) <= 0 && c.compareTo(a) <= 0)
            ans = c;
        return ans;
    }
}