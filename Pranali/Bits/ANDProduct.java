import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ANDProduct {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ANDProduct sol1 = new ANDProduct();
        sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t <  T; t++) {
            long a = s.nextLong();
            long b = s.nextLong();
            if (a == b) {
                System.out.println(a);
            }
            else {
                long num = 0;
                for (int i = 31; i >=0 ; i--) {
                    long div = (long) Math.pow (2, i);
                    long remainder = a % div;
                    long hops = div - remainder;
                    if (hops > (b-a)) {
                        //remain same
                        long digit = a / div;
                        digit = digit % 2;
                        num = num*2 + digit;
                    }
                    else {
                        num = num*2 + 0;
                    }
                }
                System.out.println(num);
            }
        }
    }
}