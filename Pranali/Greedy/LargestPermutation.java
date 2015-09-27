import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LargestPermutation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        LargestPermutation sol1 = new LargestPermutation();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger k = sc.nextBigInteger();
        if (k.compareTo(new BigInteger(n + "")) >= 0) {
            for (int i = n; i >= 1 ; i--)
                System.out.print(i + " ");
            return;
        }
        int[] pos = new int[n];
        int[] rev_pos = new int[n];
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            pos[val - 1] = i;
            rev_pos[i] = val-1;
        }
        BigInteger count = BigInteger.ZERO;
        int new_pos = 0;
        while (count.compareTo(k) < 0 && new_pos <n) {
            int top = n-1-new_pos;
            int old_pos = pos[top];
            int old_element = rev_pos[new_pos];
            if (old_element == top) {
                new_pos++;
                continue;
            }
            pos[top] = new_pos;
            rev_pos[new_pos] = top;
            pos[old_element] = old_pos;
            rev_pos[old_pos] = old_element;
            count = count.add(BigInteger.ONE);
            new_pos++;
        }
        for(int i = 0 ;i < n; i++)
            System.out.print((rev_pos[i]+1) + " ");
    }
}