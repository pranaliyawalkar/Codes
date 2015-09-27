import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AnotherKnapsack {
    int n;
    int m;
    int count = 0;
    ArrayList<Integer> visited = new ArrayList<Integer>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    AnotherKnapsack sol1 = new AnotherKnapsack();
        sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        for (int i = 0; i < n; i++) {
            visited.add(0);
        }
        recur(m);
        System.out.println(count);
    }
    public void recur(int sum) {
        if (sum == 0) {
            return;
        }
        if (sum > (n * (n+1))/2) {
            count = -1;
            return;
        }
        if (sum < 0) {
            count = -1;
            return;
        }
        int lim = 0;
        if (sum <= n) {
            lim = sum - 1;
        }
        if (sum > n) {
            lim = n-1;
        }
        int x = 0;
        for (int i = lim ; i >=0 ; i--) {
            if (visited.get(i) ==0) {
                x = i+1;
                visited.set(i, 1);
                break;
            }

        } 
        sum = sum - x;
        if (count != -1)
            count++;
        recur(sum);
    }
}