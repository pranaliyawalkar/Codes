import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    SherlockAndArray sol1 = new SherlockAndArray();
        sol1.process();
        
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int  t = 0; t < T; t++) {
            int n = s.nextInt();
            ArrayList<Integer> num = new ArrayList<Integer>();
            ArrayList<Integer> sum = new ArrayList<Integer>();
            for (int i = 0; i < n ; i++) {
                int number = s.nextInt();
                num.add(number);
                if (i ==0 ) {
                    sum.add(number);
                }
                else {
                    sum.add(sum.get(i-1) + number);
                }
            }
            boolean flag = false;
            for (int i = 0; i < n ; i++) {
                int sum1;
                int sum2;
                if (i > 0 ) 
                     sum1 = sum.get(i-1);
                else sum1 = 0;
                if (i < n-1 ) 
                     sum2 = sum.get(n-1) - sum.get(i);
                else sum2 = 0;
                if (sum1 == sum2) {
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("NO");
            }
        }
    }
}