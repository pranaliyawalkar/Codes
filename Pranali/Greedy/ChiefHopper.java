import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChiefHopper {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ChiefHopper sol1 = new ChiefHopper();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            num.add(sc.nextInt());
        }
        int min = 0;
        for (int i = n-1; i >=0; i--) {
            min = (int)Math.ceil((min + (float)num.get(i) ) / 2);
        }
        System.out.println(min);
    }
}