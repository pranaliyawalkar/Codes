import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Equal {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Equal sol1 = new Equal();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] num = new int[n];
            int min = 9999999;
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
                if (min > num[i])
                    min = num[i];
            }
            ArrayList<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i <=5; i++) {
                int ans_temp = min-i;
                int sum = 0;
                for (int j = 0; j<n; j++) {
                    sum = sum + function(Math.abs(num[j] - ans_temp));
                }
                ans.add(sum);
            }
            Collections.sort(ans);
            System.out.println(ans.get(0));
        }
    }
    public int function(int n) {
        int ans = 0;
        ans = ans + n/5;
        n = n%5;
        ans = ans + n/2;
        n = n%2;
        ans = ans + n;
        return ans;
    }
}