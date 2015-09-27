import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunnyString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    FunnyString sol1 = new FunnyString();
    sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        String temp = s.nextLine();
        for (int t = 0; t < T ; t++) {
            String str = s.nextLine();
            int i = 0;
            int n = str.length();
            boolean flag = true;
            while (i <= (n -2)) {
                int a = Math.abs((int)str.charAt(i) - (int)str.charAt(i+1));
                int b = Math.abs((int)str.charAt(n - i - 1) - (int)str.charAt(n - i - 2));
                //System.out.println("Printing " + a + "  " + b + " " + str + "  " + i);
                if (a != b) {
                    flag = false;
                }
                i++;
            }
            if (flag)
                System.out.println("Funny");
            else
                System.out.println("Not Funny");
        }
    }
}