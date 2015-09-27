import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ManasaAndStones {

    TreeSet <Long> ans = new TreeSet <Long>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    ManasaAndStones sol1 = new ManasaAndStones();
        sol1.process();
    }
    public void process () {
        Scanner sc  = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0 ; t < T; t++) {
            ans = new TreeSet <Long>();
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            get_ans(0, a, b, n, 0);
            Iterator it = ans.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
            
        }
    }
    public void get_ans (int index, int a, int b, int n, long sum) {
        /*if (index == n-1) {
            ans.add(sum);
            return;
        }
        get_ans(index + 1, a, b, n,  sum+a);
        get_ans(index+1, a, b, n, sum+b);*/
        long min = (long)(n-1)*a;
        long max = (long)(n-1)*b;
        ans.add(min);
        ans.add(max);
        while (true) {
            max = max - b + a;
            if (max == min)
                break;
            ans.add(max);
            
        }
    }
}