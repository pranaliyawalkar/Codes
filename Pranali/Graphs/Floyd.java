import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Floyd {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Floyd sol1 = new Floyd();
        sol1.process();
    }
    public void process() {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dist = new int[n][n];
        for (int i = 0 ;i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if (i != j)
                    dist[i][j] = 9999999;
            }
        }
        for (int i = 0; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a--;
            b--;
            dist[a][b] = c;
        }
        for (int k = 0;k <n ; k++) {
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < n ; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        int q = sc.nextInt();
        for (int i = 0 ; i< q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            if (dist[a][b] != 9999999)
                System.out.println(dist[a][b]);
            else
                System.out.println("-1");
        }
    }
}