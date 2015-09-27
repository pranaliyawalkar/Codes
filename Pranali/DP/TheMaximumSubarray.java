import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheMaximumSubarray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    TheMaximumSubarray sol1 = new TheMaximumSubarray();
    sol1.process();
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t = 0; t < T; t++) {
            int n = s.nextInt();
            ArrayList<Integer> num = new ArrayList<Integer>();
            for (int i = 0;i < n; i ++) {
                num.add(s.nextInt());
            }
            int x = sol1(num);
            int y = sol2(num);
            System.out.println(x + " " + y);
        }
    }
    public int sol1 (ArrayList<Integer> num) {
        int n = num.size();
        int max_till_now = 0;
        int max_ending_here = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(num.get(i) > 0) {
                flag = true;
                break;
            }
        } 
        if(flag == false) {
            int min = -999;
            for(int i = 0; i < n; i++) {
                if (num.get(i) > min)
                    min = num.get(i);
            }
            return min;
        }    
                
        for (int i = 0; i < n; i++) {
            max_ending_here += num.get(i);
            if(max_ending_here < 0)
                max_ending_here = 0;
            if (max_till_now < max_ending_here)
                max_till_now = max_ending_here;
        }
        return max_till_now;
    }
    public int sol2 (ArrayList<Integer> num) {
        int n = num.size();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(num.get(i) > 0) {
                flag = true;
                break;
            }
        } 
        if(flag == false) {
            int min = -999;
            for(int i = 0; i < n; i++) {
                if (num.get(i) > min)
                    min = num.get(i);
            }
            return min;
        }  
        int sum = 0;
        for(int i = 0; i < n; i++ ) {
            if(num.get(i) > 0) 
                sum += num.get(i);
        }
        return sum;
    }
}