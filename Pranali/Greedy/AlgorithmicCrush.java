import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlgorithmicCrush {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        AlgorithmicCrush sol1 = new AlgorithmicCrush();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<BigInteger> num = new ArrayList<BigInteger>();
        for (int i = 0; i < n ; i++) {
            num.add(BigInteger.ZERO);
        }
        for (int i =0; i < m ; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            BigInteger k = sc.nextBigInteger();
            num.set(a, num.get(a).add(k));
            if (b+1 < n)    
                num.set(b+1, num.get(b+1).subtract(k));
        }
        
        //System.out.println(num);
        BigInteger max = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < n; i++) {
            sum = sum.add(num.get(i));
            if(max.compareTo(sum) < 0)
                max = sum;
        }
        System.out.println(max);
    }
}