import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlippingBits {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        FlippingBits sol1 = new FlippingBits();
        sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        long constant = (long) Math.pow(2, 32);
        constant = constant - 1;
        for (int t = 0; t < T; t++) {
            long num = s.nextLong();
            System.out.println(constant - num);
        }
    }
}