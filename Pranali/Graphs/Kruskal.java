import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class edge {
    int s;
    int e;
    int w;
}

class node {
    ArrayList<Integer> children = new ArrayList<Integer>();
}

class edge_comparator implements Comparator<edge> {
    public int compare (edge e1, edge e2) {
        if (e1.w - e2.w !=0)
            return e1.w - e2.w;
        return e1.s + e1.e + e1.w - e2.s - e2.e - e2.w;
    }
}

public class Kruskal {

    ArrayList<node> nodes;
    int n;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Kruskal sol1 = new Kruskal();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<edge> edges = new ArrayList<edge>();
        HashMap<String, Integer> v = new HashMap<String, Integer>();
        for (int i = 0 ;i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a = a-1;
            b = b-1;
            if (v.get(a+ "_" + b)!=null && v.get(a+ "_" + b) < c)
                continue;
            v.put(a + "_" + b, c);
            edge e1 = new edge();
            e1.s = a;
            e1.e = b;
            e1.w = c;
            edges.add(e1);
        }
        Collections.sort(edges, new edge_comparator());
        /*for (int i = 0; i < m ; i++) {
            System.out.println(edges.get(i).s + "  " + edges.get(i).e + "  " + edges.get(i).w);
        }*/
        ArrayList<Integer> visited = new ArrayList<Integer>();
        int i = 0;
        int count = 0;
        int edge_count = 0;
        nodes = new ArrayList<node>();
        for (i = 0; i < n ; i++)
            nodes.add(new node());
        i = 0;
        while (true) {
            edge e1 = edges.get(i);
            boolean test = path(e1.s, e1.e, new ArrayList<Integer>());
            //System.out.println(i + "  " + e1.s + " " + e1.e + " " + e1.w + " " + test);
            if (!test) {
                if (!visited.contains(e1.s))
                    visited.add(e1.s);
                if (!visited.contains(e1.e))
                    visited.add(e1.e);
                count = count + e1.w;
                edge_count++;
                
                ArrayList<Integer> temp =  new ArrayList<Integer>();
                temp.addAll(nodes.get(e1.s).children);
                temp.add(e1.e);
                nodes.get(e1.s).children.clear();
                nodes.get(e1.s).children.addAll(temp);
                
                temp.clear();
                temp.addAll(nodes.get(e1.e).children);
                temp.add(e1.s);
                nodes.get(e1.e).children.clear();
                nodes.get(e1.e).children.addAll(temp);
                //System.out.println("Added " + e1.s + " " + e1.e + " " + e1.w);
                /*for (i = 0; i < n ;i++) {
                    System.out.println(i + "  " + nodes.get(i).children);
                }*/
            }
            i++;
            if (visited.size() == n && edge_count == n-1)
                break;
        }
        //System.out.println(visited);
        System.out.println(count);
    }
    public boolean path(int s, int e, ArrayList<Integer> visited) {
        node n1 = nodes.get(s);
        if (!visited.contains(s))
            visited.add(s);
        if (n1.children.contains(e)) {
            //System.out.println("found");
            return true;
        }
        else {
            for (int i = 0; i < n1.children.size(); i++) {
                if (!visited.contains(n1.children.get(i))) {
                    visited.add(n1.children.get(i));
                    boolean test = path(n1.children.get(i), e, visited);
                    //System.out.println("check " + test);
                    if (test)
                        return true;
                }
            }
        }
        return false;
    }
}