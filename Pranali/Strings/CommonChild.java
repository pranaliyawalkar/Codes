import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CommonChild {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    CommonChild sol1 = new CommonChild();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int size1 = s1.length();
        int size2 = s1.length();
        int[][] mat = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                int a = 0;
                int b = 0;
                int c = 0;
                if (i-1 >=0)
                    a = mat[i-1][j];
                if (j-1 >=0)
                    b = mat[i][j-1];
                if (i-1 >=0 && j-1>=0)
                    c = mat[i-1][j-1];
                if (s1.charAt(i) == s2.charAt(j))
                    c = c+1;
                int max = a;
                if (b > max)
                    max = b;
                if (c > max)
                    max = c;
                mat[i][j] = max;
            }
        }
        System.out.println(mat[size1-1][size2-1]);
    }
}