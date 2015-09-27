import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XoringNinja {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    XoringNinja sol1 = new XoringNinja();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            BigInteger sum = BigInteger.ZERO;
            for (int i = 0; i < n ; i++)
                sum = sum.or(sc.nextBigInteger());
            BigInteger mul = (new BigInteger("2")).pow(n-1);
            BigInteger ans = (sum).multiply(mul);
            System.out.println(ans.mod(new BigInteger("1000000007")));
        }
    }
}