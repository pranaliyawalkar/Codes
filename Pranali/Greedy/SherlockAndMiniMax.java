import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndMiniMax {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        SherlockAndMiniMax sol1 = new SherlockAndMiniMax();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i =0 ; i < n; i++) {
            num.add(sc.nextInt());
        }
        Collections.sort(num);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int max = -99;
        int max_ans = 0;
        int l = bs(num, p).get(0);
        int l1 = l;
        int cons = num.get(l1);
        int cons2 = num.get(l1+1);
        int x = p;
        while(x <= q) {
            if (x <= cons) {
                int ans = Math.abs(cons - x);
                if (ans > max) {
                    max = ans;
                    max_ans = x;
                }
                x++;
            }
            else if (x > cons && x <= (cons + cons2)/2) {
                int ans = Math.abs(cons - x);
                if (ans > max) {
                    max = ans;
                    max_ans = x;
                }
                x++;
            }
            else if (x <=cons2 && x > cons && x > (cons + cons2)/2) {
                int ans = Math.abs(cons2 - x);
                if (ans > max) {
                    max = ans;
                    max_ans = x;
                }
                x++;
            }
            else if (x > cons2) {
                if (l1 == n-1) {
                    cons = num.get(l1);
                    cons2 = num.get(l1);
                    int ans = Math.abs(cons2 - x);
                    if (ans > max) {
                        max = ans;
                        max_ans = x;
                    }
                    x++;
                }
                else {
                    l1++;
                    cons = num.get(l1);
                    if (l1+1 != n)
                        cons2 = num.get(l1+1);
                    else
                        cons2 = cons;
                }
            }
        }
        System.out.println(max_ans);
    }
    public ArrayList<Integer> bs(ArrayList<Integer> num, int x) {
        int l = 0;
        int r = num.size() - 1;
        int m = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (l < r) {
            if (l == r-1) {
                ans.add(l);
                ans.add(r);
                return ans;
            }
            m = (l + r) / 2;
            if (x < num.get(m))
                r = m;
            if (x > num.get(m))
                l = m;
            if (x == num.get(m)) {
                ans.add(m);
                return ans;
            }
        }
        return ans;
    }
}