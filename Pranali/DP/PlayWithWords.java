import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlayWithWords {
    long[][]dp;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PlayWithWords sol1 = new PlayWithWords();
        sol1.process();
    }
    
    public void process() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long max = Long.MIN_VALUE;
        int n = s.length();
        int max_index = 0;
        long max_a = 0;
        long max_b = 0;
        largest_palindromic_subsequence(s);
        for (int i = 0; i <n-1; i++) {
            long a = dp[0][i];
            long b = dp[i+1][n-1];
            long ans = a*b;
            if (ans > max) {
            	max  = ans;
            	max_index = i;
            	max_a = a;
            	max_b = b;
            }
        }
        //System.out.println(max_a + "  " + max_b);
        //System.out.println(max_index);
        System.out.println(max);
    }
    
    public long largest_palindromic_subsequence(String s) {
        int n = s.length();
        dp = new long[n][n];
        for (int i = 0; i < n ; i++) {
        	//if (s.charAt(i) == s.charAt(0))
        		dp[i][i] = 1;
        	//if (i > 0 && dp[0][i-1] ==1)
        		//dp[0][i] = 1;
        }
        for (int gap = 2; gap <= n ; gap++) {
            for (int i = 0; i < n-gap+1 ; i++) {
            	int j = i + gap - 1;
            	if (s.charAt(i) == s.charAt(j) && gap==2) {
                		dp[i][j] = 2;
                }
                else {
                    long a = 0;
                    long b = 0;
                    long c = 0;
                    if (i+1 < n)
                        a = dp[i+1][j];
                    if (j > 0)
                        b = dp[i][j-1];
                    if (i+1 < n && j > 0)
                        c = dp[i+1][j-1];
                    
                    if (s.charAt(i) == s.charAt(j)) {
                    	 c = c + 2;
                    	 dp[i][j] = c;
                    }
                    else {
                    	long max = a;
                        if (b > max)
                            max = b;
                        
                        dp[i][j] = max;
                    }
                }
            }
        }
        /*System.out.println("String : " + s);
        for (int i = 0; i < n ; i++) {
        	for (int j = 0; j < n; j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }
        System.out.println("*********************");*/
        return dp[0][n-1];
    }
}