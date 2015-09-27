import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class pizza {
    long t;
    long l;
}
class pizza_comparator1 implements Comparator<pizza> {
    public int compare(pizza p1, pizza p2) {
        long l1 = p1.t;
        long l2 = p2.t;
        return Long.compare(l1, l2);
    }
}

class pizza_comparator2 implements Comparator<pizza> {
    public int compare(pizza p1, pizza p2) {
        long l1 = p1.l;
        long l2 = p2.l;
        return Long.compare(l1, l2);
    }
}

public class MinimumAverageWaitingTime {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    MinimumAverageWaitingTime sol1 = new MinimumAverageWaitingTime();
    sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<pizza> all_pizzas = new ArrayList<pizza>();
        for (int i = 0; i < n; i++) {
            pizza p = new pizza();
            p.t = s.nextLong();
            p.l = s.nextLong();
            all_pizzas.add(p);
        }
        Collections.sort(all_pizzas, new pizza_comparator1());
        PriorityQueue<pizza> minheap = new PriorityQueue<pizza>(100 , new pizza_comparator2());
        long curr_time = 0;
        int index = 0;
        long total_time = 0;
        while (true) {
            int i;
            for (i = index; i < n; i++) {
                pizza p = all_pizzas.get(i);
                if(p.t <= curr_time) {
                    minheap.offer(p);
                }
                else {
                    index = i;
                    break;
                }
            }
            if(i == n) 
                index = n;
            if (minheap.size() > 0) {
                pizza p = minheap.poll();
                total_time += curr_time + p.l - p.t;
                curr_time += p.l;
    
            }
            else if (index < n) {
                curr_time = all_pizzas.get(index).t;
            }
            if (index == n && minheap.size() == 0)
                break;
        }
        System.out.println(total_time/n);
    }
}