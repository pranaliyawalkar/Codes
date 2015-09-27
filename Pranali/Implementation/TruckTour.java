import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class pump {
    int p;
    int d;
}

public class TruckTour {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    TruckTour sol1 = new TruckTour();
    sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<pump> all_pumps = new ArrayList<pump>();
        for (int i = 0; i < n; i ++) {
            pump p = new pump(); 
            p.p = s.nextInt();
            p.d = s.nextInt();
            all_pumps.add(p);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        int curr = 0;
        int start = 0;
        int end = 1;
        q.offer(start);
        curr = all_pumps.get(0).p - all_pumps.get(0).d; 
        while (end != start) {
            while (curr < 0 && q.size()>0) {
                int top = q.poll();
                curr = curr - all_pumps.get(top).p + all_pumps.get(top).d; 
            }
            if (q.size() > 0)  
                start = q.peek();
            q.offer(end);
            curr = curr + all_pumps.get(end).p - all_pumps.get(end).d;
            end = (end + 1) % n;
        }
        System.out.println(start);
    }
}