import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class edge {
    int end;
    int w;
}
class edge_comp implements Comparator<edge> {
    public int compare (edge e1, edge e2) {
        return e1.w - e2.w;
    }
}

public class PrimMST {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PrimMST sol1 = new PrimMST();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<edge>> ad = new ArrayList<ArrayList<edge>>();
        for (int i = 0; i < n ; i++)
            ad.add(new ArrayList<edge>());
        for (int i = 0 ; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a = a -1;
            b = b-1;
            edge e1 = new edge();
            e1.end = b;
            e1.w = c;
            edge e2 = new edge();
            e2.end = a;
            e2.w = c;
            ad.get(a).add(e1);
            ad.get(b).add(e2);
        }
        for (int i = 0 ; i< n ; i++)
            Collections.sort(ad.get(i), new edge_comp());
        int s = sc.nextInt();
        s = s-1;
        int[] visited = new int[n];
        int count = 0;
        visited[s] = 1;
        while(true) {
            ArrayList<edge> new_ones = new ArrayList<edge>();
            for (int i = 0; i < n ; i++) {
                if (visited[i] == 1) {
                    ArrayList<edge> my_edges = ad.get(i);
                    for (int j = 0; j < my_edges.size(); j++) {
                        if (visited[my_edges.get(j).end] == 0) {
                            new_ones.add(my_edges.get(j));
                            break;
                        }
                    }
                }
            }
            if (new_ones.size() == 0)
                break;
            else {
                Collections.sort(new_ones, new edge_comp());
                count = count + new_ones.get(0).w;
                visited[new_ones.get(0).end] = 1;
            }
        }
        System.out.println(count);
    }
}