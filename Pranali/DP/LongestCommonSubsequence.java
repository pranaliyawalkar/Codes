import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    LongestCommonSubsequence sol1 = new LongestCommonSubsequence();
    sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        int[][] matrix = new int[n][m];
        int[][] path = new int[n][m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            if (i>0 && matrix[i-1][0] ==1) {
                matrix[i][0] = 1;
            }
            else {
                if (a[i] == b[0])
                    matrix[i][0] = 1;
            }
        }
        for (int i = 0; i < m ; i++) {
            if (i > 0 && matrix[0][i-1] ==1) {
                matrix[0][i] = 1;
            }
            else {
                if (b[i] == a[0])
                    matrix[0][i] = 1;
            }
        }
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j< m ; j++) {
                if (a[i] == b[j]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    path[i][j] = 2;
                }
                else {
                    if (matrix[i-1][j] >= matrix[i][j-1] ) {
                        matrix[i][j] = matrix[i-1][j];
                        path[i][j] = 1;
                    }
                    else {
                        matrix[i][j] = matrix[i][j-1];
                        path[i][j] = -1;
                    }
                }
            }
        }
        /*for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }*/
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = n-1;
        int j = m-1;
        while(true) {
            if(i == 0 || j == 0) {
                if (i == 0) {
                    if (matrix[i][j-1] == 1) {
                        j = j-1;
                    }
                    else {
                        ans.add(a[i]);
                        break;
                    }
                }
                else if (j == 0) {
                    if (matrix[i-1][j] == 1) {
                        i = i-1;
                    }
                    else {
                        ans.add(a[i]);
                        break;
                    }
                }
            }
            if (i == 0 && j == 0) {
                if (a[0] == b[0])
                    ans.add(a[0]);
                break;
            }
            if (path[i][j] == 2) {
                ans.add(a[i]);
                i = i-1;
                j = j-1;
            }
            else if (path[i][j] == 1) {
                i = i-1;
            }
            else if (path[i][j] == -1) {
                j = j-1;
            }
        }
        for (i = ans.size()-1; i >=0; i--) {
            System.out.print(ans.get(i) + " ");
        }
    }
}