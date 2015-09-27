import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Candies {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Candies sol1 = new Candies();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] last = new int[n];
        int sum = 0;
        
        for (int i = 0; i < n ; i++) {
            num[i] = sc.nextInt(); 
            last[i] = -1;
        }
        last[0] = 1;
        for (int i = 1; i < n ; i++ ) {
            if (num[i] > num[i-1])
                last[i] = last[i-1] + 1;
            if (num[i] == num[i-1])
                last[i] = 1;
            if (num[i] < num[i-1]) {
                last[i] = 1;
                int j = i-1;
                while (j >= 0 && last[j] == last[j+1] && num[j] > num[j+1]) {
                    last[j] = last[j] + 1;
                    j--;
                }
            }
        }
        for (int i = 0; i < n ; i++)
            sum += last[i];
        System.out.println(sum);
    }
}