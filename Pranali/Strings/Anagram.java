import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Anagram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Anagram sol1  = new Anagram();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String temp = sc.nextLine();
        for (int t= 0 ;t < T; t++) {
            String s = sc.nextLine();
            int n = s.length();
            if (n % 2 ==1) {
                System.out.println("-1");
                continue;
            }
            int[] a = new int[26];
            int[] b = new int[26];
            for (int i = 0; i < n/2; i++) {
                a[s.charAt(i) - 'a']++;
            }
            for (int i = n/2; i < n; i++) {
                b[s.charAt(i) - 'a']++;
            }
            int count = 0;
            for (int i = 0; i < 26 ; i++) {
                if (b[i] > a[i])
                    count = count + b[i] - a[i];
            }
            System.out.println(count);
        }
    }
}