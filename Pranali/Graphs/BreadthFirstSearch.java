import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BreadthFirstSearch sol1 = new BreadthFirstSearch();
        sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0 ; t < T; t++) {
            int n = s.nextInt();
            int m = s.nextInt();
            ArrayList<ArrayList<Integer>> ad = new ArrayList<ArrayList<Integer>>();
            ArrayList<Boolean> visited = new ArrayList<Boolean>();
            ArrayList<Integer> l = new ArrayList<Integer>();
            for (int i = 0 ; i < n ; i++) {
                ad.add(new ArrayList<Integer>());
                visited.add(false);
                l.add(0);
            }
            for (int i = 0; i < m ; i++) {
                int n1 = s.nextInt();
                int n2 = s.nextInt();
                ad.get(n1-1).add(n2-1);
                ad.get(n2-1).add(n1-1);
            }
            int num = s.nextInt();
            Queue <Integer> q = new LinkedList<Integer>();
            q.offer(num-1);
            visited.set(num-1, true);
            while (q.size() > 0) {
                int top = q.poll();
                ArrayList<Integer> my_ad = ad.get(top);
                
                for (int i = 0; i < my_ad.size(); i++) {
                    if (visited.get(my_ad.get(i)) == false) {
                         q.offer(my_ad.get(i));
                         l.set(my_ad.get(i), l.get(top) + 1);
                         visited.set(my_ad.get(i), true);
                    }
                       
                }
                    
            }
            for (int i = 0; i < n ; i++) {
                if (i != num-1) {
                    if (l.get(i) !=0 )
                        System.out.print(l.get(i)*6 + " ");
                    else
                        System.out.print(-1 + " ");
                }
            }
            System.out.println();
        }
    }
}