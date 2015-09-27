import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BiggerIsGreater {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    BiggerIsGreater sol1 = new BiggerIsGreater();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String temp = sc.nextLine();
        ArrayList<String> strings = new ArrayList<String>();
        for (int t = 0; t < T; t++) {
            String s = sc.nextLine();
            strings.add(s);
        }
        sc.close();
        for (int p = 0 ; p < T; p++)
        {
        	String s = strings.get(p);
            int size = s.length();
            char[] num = new char[size];
            if (size == 0)
                continue;
            if (size == 1) {
                System.out.println(s);
                continue;
            }
            for (int i = 0; i < size; i++) {
                num[i] = s.charAt(i);
            }
            int i = 0;
            
            boolean flag = false;
            for (i = size-1; i>0; i--) {
                if (num[i] >  num[i-1]) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                //already sorted
                System.out.println("no answer");
                continue;
            }
            int j =0;
            for (j = size-1; j >=i; j--) {
                if (num[j] > num[i-1])
                    break;
            }
            char temp1 = num[i-1];
            num[i-1] = num[j];
            num[j]  = temp1;
            //System.out.println(num);
            //Collections.sort(num.subList(i, num.size()));
            //System.out.println(num);
            //System.out.println("test " + p + " " + s);
            for (int k = 0 ; k < i; k++)
                System.out.print(num[k]);
            for (int k = size-1; k >=i ; k--)
                System.out.print(num[k]);
            System.out.println();
            //System.out.println("********************");
        }
        
    }
}