import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GridChallenge {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    GridChallenge sol1 = new GridChallenge();
    sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0 ;t < T; t++) {
            int n = sc.nextInt();
            String temp = sc.nextLine();
            ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n ; i++) {
                ArrayList<Integer> row = new ArrayList<Integer>();
                String string_row = sc.nextLine();
                for (int j = 0; j < n ; j++) {
                    row.add(string_row.charAt(j) - 'a');
                }
                Collections.sort(row);
                mat.add(row);
            }
            boolean flag = true;
            for (int i = 0; i < n-1 ; i++) {
                for (int j = 0; j < n ; j++) {
                    if (mat.get(i).get(j) > mat.get(i+1).get(j)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag == false)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}