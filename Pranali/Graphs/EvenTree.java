import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class node {
    int sub_count;
    ArrayList<Integer> children;
}

public class EvenTree {
    int count = 0;
    ArrayList<node> nodes;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    EvenTree sol1 = new EvenTree();
        sol1.process();
    }
    public void process () {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        nodes = new ArrayList<node>();
        for (int i = 0; i < n ; i++) {
            node n1 = new node();
            n1.sub_count = -1;
            n1.children = new ArrayList<Integer>();
            nodes.add(n1);
        }
        for(int i = 0; i < m ; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (a < b) {
                node n1 = nodes.get(a-1);
                n1.children.add(b-1);
                nodes.set(a-1, n1);
            }
            else {
                node n1 = nodes.get(b-1);
                n1.children.add(a-1);
                nodes.set(b-1, n1);    
            }
            
        }
        process2(0);
        System.out.println(count - 1);
    }
    public int process2(int index) {
        if (nodes.get(index).sub_count == -1) {
            int sum = 0;
            for (int i = 0 ; i < nodes.get(index).children.size(); i++) {
                sum = sum + process2(nodes.get(index).children.get(i));
            }
            sum++;
            nodes.get(index).sub_count = sum;
            if (sum % 2 ==0)
                count++;
            return sum;
        }
        else {
            return nodes.get(index).sub_count;
        }
    }
}