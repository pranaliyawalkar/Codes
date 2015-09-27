import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PriyankaAndToys {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    PriyankaAndToys sol1 = new PriyankaAndToys();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < n ; i++)
            num.add(sc.nextInt());
        Collections.sort(num);
        int a = num.get(0);
        int b = a + 4;
        int count = 1;
        int i = 0;
        while (true) {
            while(i < n && num.get(i) <= b && num.get(i) >=a)
                i++;
            if (i >= n)
                break;
            count++;
            a = num.get(i);
            b = a + 4;
            
        }
        System.out.println(count);
    }
}