import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class node {
    int id;
    int value;
}

class item {
    int id;
    int dist;
}

class item_comparator implements Comparator<item> {
    public int compare(item i1, item i2) {
        return i1.dist - i2.dist;
    }
}

public class JackGoesToRapture {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    JackGoesToRapture sol1 = new JackGoesToRapture();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<node>> ad = new ArrayList<ArrayList<node>>();
        for (int i = 0; i < n ; i++)
            ad.add(new ArrayList<node>());
        for (int i = 0; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            int c =sc.nextInt();
            node n1 = new node();
            n1.id = b;
            n1.value = c;
            ad.get(a).add(n1);
            node n2 = new node();
            n2.id = a;
            n2.value = c;
            ad.get(b).add(n2);
        }
        int ans = dj(n, ad);
        if (ans != -1)  
            System.out.println(ans);
        else 
            System.out.println("NO PATH EXISTS");
    }
    public int dj(int n, ArrayList<ArrayList<node>> ad) {
        int[] dist = new int[n];
        for (int i = 1 ; i < n ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<item> pq = new PriorityQueue<item>(10, new item_comparator());
        item i3 = new item();
        i3.id = 0;
        i3.dist = 0;
        pq.add(i3);
        while(pq.size() > 0) {
            item i1 = pq.poll();
            if (i1.id == n-1)
                break;
            for (int i = 0; i < ad.get(i1.id).size(); i++) {
                int temp = ad.get(i1.id).get(i).value - i1.dist;
                if (temp < 0)
                    temp = 0;
                temp = temp + i1.dist;
                if (temp < dist[ad.get(i1.id).get(i).id]) {
                    dist[ad.get(i1.id).get(i).id] = temp;
                    item i2 = new item();
                    i2.id = ad.get(i1.id).get(i).id;
                    i2.dist = temp;
                    pq.add(i2);
                }
            }
        }
        if (dist[n-1] != Integer.MAX_VALUE)
            return dist[n-1];
        else return -1;
    }
}