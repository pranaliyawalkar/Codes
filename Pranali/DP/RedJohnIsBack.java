import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RedJohnIsBack {

    int[] m;
    //int[] p;
    int n;
    int count;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    RedJohnIsBack sol1 = new RedJohnIsBack();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0;t < T; t++) {
            n = sc.nextInt();
            m = new int[n+1 + 4];
            //p = new int[n+1 + 4];
            count = 0;
            m[0] = 0;
            m[1] = 1;
            m[2] = 1;
            m[3] = 1;
            m[4] = 2;
            /*p[0] = 0;
            p[1] = 0;
            p[2] = 1;
            p[3] = 2;
            p[4] = 2;*/
            int prime = 0;
            
            count = process2(n);
            //System.out.println("count " + count);
            //for (int i = 0; i <= n ; i++)
            //    System.out.print(p[i] +  " ");
            for (int i = 2; i <= count; i++) {
                if (prime (i))
                    prime++;
            }
            System.out.println(prime);
        }
    }
    public boolean prime(int x) {
        if (x == 2)
            return true;
        if (x == 3)
            return true;
        if (x == 4)
            return false;
        for (int i = 2; i <= Math.sqrt(x) ; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
    public int process2(int x) {
        if (x == 0)
            return 0;
        if (m[x] !=0)
            return m[x];
        int val = 0;
        if (x >= 4) {
            val = val + process2(x-4);
        }
        val = val + process2(x-1);
        //p[x] = p[x-1];
        //if (prime(x) && x>4)
        //    p[x] = p[x] + 1;
        m[x]  = val;
        return val;
    }
}