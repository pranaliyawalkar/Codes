import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountLuck {
    int [][]matrix;
    int sx = 0;
    int sy = 0;
    int ex = 0;
    int ey = 0;
    int k;
    int n;
    int m;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    CountLuck sol1 = new CountLuck();
    sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            matrix = new int[n][m];
            String temp = sc.nextLine();
            for (int i = 0; i < n ; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < m ;j++) {
                    if (s.charAt(j) == 'X')
                        matrix[i][j] = 1;
                    else if (s.charAt(j) == '.')
                        matrix[i][j] = 0;
                    else if (s.charAt(j) == 'M') {
                        matrix[i][j] = 1;
                        sx = i;
                        sy = j;
                    }
                    else if (s.charAt(j) == '*') {
                        ex = i;
                        ey = j;
                    }
                }
            }
            k = sc.nextInt();
            boolean ans = process2(sx, sy, 0);
            if(ans == true) 
                System.out.println("Impressed");
            else
                System.out.println("Oops!");
        }
    }
    public boolean process2(int x, int y, int val) {
        matrix[x][y] = 1;
        if (x == ex && y == ey) {
            //System.out.println("test " + val);
            if (val == k)
                return true;
            return false;
        }
        int count = 0;
        if ((x + 1 < n) && matrix[x+1][y] == 0) {
            count++;
        }
        if ((x - 1 >= 0) && matrix[x-1][y] == 0) {
            count++;
        }
        if ((y + 1 < m) && matrix[x][y+1] == 0) {
            count++;
        }
        if ((y - 1 >= 0) && matrix[x][y-1] == 0) {
            count++;
        }
        if (count > 1) {
            //many options
            val = val + 1;
            //System.out.println("Found " + x + " " + y + " "+ val);
        }
        int[][] original = matrix;
        if ((x + 1 < n) && matrix[x+1][y] == 0) {
            boolean ans = process2(x+1, y, val);
            if(ans == true)
                return true;
        }
        matrix = original;
        if ((x - 1 >= 0) && matrix[x-1][y] == 0) {
            boolean ans = process2(x-1, y, val);
            if(ans == true)
                return true;
        }
        matrix = original;
        if ((y + 1 < m) && matrix[x][y+1] == 0) {
            boolean ans = process2(x, y+1, val);
            if(ans == true)
                return true;
        }
        matrix = original;
        if ((y - 1 >= 0) && matrix[x][y-1] == 0) {
            boolean ans = process2(x, y-1, val);
            if(ans == true)
                return true;
        }
        return false;
    }
}