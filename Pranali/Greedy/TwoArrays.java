import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoArrays {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    TwoArrays sol1 = new TwoArrays();
    sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0 ; t < T; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n ; i++)
                a[i] = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n ; i++)
                b[i] = sc.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);
            int i;
            for (i = 0; i < n ; i++) {
                if (a[i] + b[n-i-1] < k)
                    break;
            }
            if (i == n)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}