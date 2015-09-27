import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConnectedCellGrid {
    int[][] matrix;
    int [][]visited;
    int n;
    int m;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    ConnectedCellGrid sol1 = new ConnectedCellGrid();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i< n ; i++) {
            for (int j =0; j < m ; j++) {
                matrix[i][j] = sc.nextInt();
                visited[i][j] = 0;
            }
        }
        /*for (int i = 0; i< n ; i++) {
            for (int j =0; j < m ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }*/
        int max_count = -9999;
        while(true) {
            int x = -1;
            int y = -1;
            boolean flag = true;
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m ; j++) {
                    if (visited[i][j] == 0 && matrix[i][j] == 1) {
                        x = i;
                        y = j;
                        flag = false;
                        break;
                    }
                }
                if (flag == false)
                    break;
            }
            //System.out.println("in loop " + x + " " + y);
            if (x == -1)
                break;
            int count = process2(x, y, 0);
            if (count > max_count)
                max_count = count;
        }
        System.out.println(max_count);
    }
    
    public int process2(int i, int j, int count) {
        count++;
        int my_count = 1;
        visited[i][j] = 1;
        if (j+1 < m && matrix[i][j+1]==1 && visited[i][j+1]==0) {
            my_count += process2(i, j+1, count);
        }
        if (i+1 < n && matrix[i+1][j]==1 && visited[i+1][j]==0) {
            my_count += process2(i+1, j, count);
        }
        if (i-1 >= 0 && matrix[i-1][j]==1 && visited[i-1][j]==0) {
            my_count += process2(i-1, j, count);
        }
        if (j-1 >= 0 && matrix[i][j-1]==1 && visited[i][j-1]==0) {
            my_count += process2(i, j-1, count);
        }
        if (j-1 >= 0 && i-1 >=0 && matrix[i-1][j-1]==1 && visited[i-1][j-1]==0) {
            my_count += process2(i-1, j-1, count);
        }
        if (j+1 < m && i-1 >=0 && matrix[i-1][j+1]==1 && visited[i-1][j+1]==0) {
            my_count += process2(i-1, j+1, count);
        }
        if (j+1 < m && i+1 < n && matrix[i+1][j+1]==1 && visited[i+1][j+1]==0) {
            my_count += process2(i+1, j+1, count);
        }
        if (j-1 >= 0 && i+1 < n && matrix[i+1][j-1]==1 && visited[i+1][j-1]==0) {
            my_count += process2(i+1, j-1, count);
        }
        return my_count;
    }
}