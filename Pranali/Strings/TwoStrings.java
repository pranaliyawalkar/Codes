import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoStrings {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    TwoStrings sol1 = new TwoStrings();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String temp = sc.nextLine();
        for (int t = 0; t < T; t++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            boolean[] a = new boolean[26];
            for (int i = 0; i < s1.length(); i++)
                a[s1.charAt(i) - 'a'] = true;
            int i = 0;
            for (i = 0; i < s2.length(); i++) {
                if (a[s2.charAt(i) - 'a'] == true) {
                    System.out.println("YES");
                    break;
                }
            }
            if (i == s2.length())
                System.out.println("NO");  
        }
    }
}