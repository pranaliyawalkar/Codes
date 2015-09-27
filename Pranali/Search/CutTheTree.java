import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class node {
    int value;
    int sum;
    ArrayList<Integer> children;
}

public class CutTheTree {
    ArrayList<node> nodes;
    int total;
    int min;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        CutTheTree sol1  = new CutTheTree();
        sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        nodes = new ArrayList<node>();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        total = 0;
        min = 99999999;
        for (int i = 0; i < n ; i++) {
            node n1 = new node();
            n1.value = s.nextInt();
            n1.sum = -1;
            n1.children = new ArrayList<Integer>();
            nodes.add(n1);
            visited.add(-1);
            total += n1.value;
        }
        boolean flag = false;
        for (int i = 0; i < (n-1); i++) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;
            nodes.get(a).children.add(b);
            nodes.get(b).children.add(a);
            
        }
        Queue <Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(q.size() >0 ) {
            int top = q.poll();
            visited.set(top, 1);
            ArrayList<Integer> new_list = new ArrayList<Integer>();
            for (int i = 0; i < nodes.get(top).children.size(); i++) {
                if (visited.get(nodes.get(top).children.get(i)) == -1) {
                    new_list.add(nodes.get(top).children.get(i));
                    visited.set(nodes.get(top).children.get(i), 1);
                    q.offer(nodes.get(top).children.get(i));
                }
            }
            node n1 = nodes.get(top);
            n1.children.clear();
            n1.children.addAll(new_list);
            nodes.set(top, n1);
        }
        process2(0);
        System.out.println(min);
    }
    public int process2(int index) {
        if (nodes.get(index).sum != -1) 
            return nodes.get(index).sum;
        else {
            int sum = nodes.get(index).value;
            for (int i = 0; i <nodes.get(index).children.size(); i++) {
                sum += process2(nodes.get(index).children.get(i));
            }
            node n1 = nodes.get(index);
            n1.sum = sum;
            nodes.set(index, n1);
            if (sum !=total) {
                int diff = Math.abs(total - 2*sum);
                if (diff < min)
                    min = diff;
            }
            return sum;
        }
    }
}