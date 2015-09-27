import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class node {
    int value;
    int dist;
    boolean visited;
}

class edge {
    int value;
    int dest;
}

class node_comparator implements Comparator <node> {
    public int compare (node n1, node n2) {
        return n1.dist - n2.dist;
    }
}

public class Dijkstra2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Dijkstra2 sol1 = new Dijkstra2();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            ArrayList<ArrayList<edge>> edges = new ArrayList<ArrayList<edge>>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < n ;i++) {
                edges.add(new ArrayList<edge>());
            }
            for (int i = 0; i < m ; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                a--;
                b--;
                edge e1 = new edge();
                e1.dest = b;
                e1.value = c;
                edges.get(a).add(e1);
                edge e2 = new edge();
                e2.dest = a;
                e2.value = c;
                edges.get(b).add(e2);
            }
            int s = sc.nextInt();
            s--;
            ArrayList<node> queue = new ArrayList<node>();
            ArrayList<node> distances = new ArrayList<node>();
            for (int i = 0; i < n ; i++) {
                node n1 = new node();
                n1.visited = false;
                n1.value = i;
                if (i == s)
                    n1.dist = 0;
                else
                    n1.dist = (Integer.MAX_VALUE);
                queue.add(n1);
                distances.add(n1);
            }
            while (true) {
                node n1 = get_min(queue);
                if (n1.dist < 0)
                    break;
                if (n1.dist == Integer.MAX_VALUE) {
                        node n2 = distances.get(n1.value);
                        n2.dist = -1;
                        distances.set(n1.value, n2);
                        n2 = queue.get(n1.value);
                        n2.dist = -1;
                        queue.set(n1.value, n2);
                        continue;
                }
                ArrayList<edge> neighbours = edges.get(n1.value);
                for (int i = 0; i < neighbours.size(); i++) {
                    int dist = n1.dist + neighbours.get(i).value;
                    //System.out.println("distances " + dist);
                    if (distances.get(neighbours.get(i).dest).dist > dist) {
                        node n2 = distances.get(neighbours.get(i).dest);
                        n2.dist = dist;
                        distances.set(neighbours.get(i).dest, n2);
                        n2 = queue.get(neighbours.get(i).dest);
                        n2.dist = dist;
                        queue.set(neighbours.get(i).dest, n2);
                        //System.out.println("Dist : " + dist + " " + queue.get(neighbours.get(i).dest).dist
                         //                 + " " + distances.get(neighbours.get(i).dest).dist);
                    }
                    //System.out.println(distances.get(neighbours.get(i).dest).value);
                }
            }
            for (int i = 0; i < n ; i++)
                if (i != s) 
                    System.out.print(distances.get(i).dist+ " ");
            System.out.println();
        }
    }
    public node get_min(ArrayList<node> queue) {
        int min = Integer.MAX_VALUE;
        int min_int = -1;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).dist <= min && queue.get(i).visited == false) {
                min = queue.get(i).dist;
                min_int = i;
            }
        }
        if (min_int == -1) {
            node n1 = new node();
            n1.dist = -1;
            return n1;
        }
        node n1 = queue.get(min_int);
        n1.visited = true;
        queue.set(min_int, n1);
        //System.out.println("Test : " + queue.get(min_int).visited);
        return n1;
    }
}