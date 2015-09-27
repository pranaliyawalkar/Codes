import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibonacciModified {
    ArrayList<BigInteger> num;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FibonacciModified sol1 = new FibonacciModified();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        num  = new ArrayList<BigInteger>();
        num.add(a);
        num.add(b);
        int n = sc.nextInt();
        for (int i = 2; i < n ; i++)
            num.add(new BigInteger("0"));
        System.out.println(process2(n-1));
    }
    public BigInteger process2(int index) {
        if(num.get(index).compareTo(BigInteger.ZERO) > 0)
            return num.get(index);
        if (index ==0 || index ==1)
            return num.get(index);
        BigInteger ans = process2(index-1).multiply(process2(index-1));
        ans = ans.add(process2(index-2));
        num.set(index, ans);
        return ans;
    }
}