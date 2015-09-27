import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlmostSorted {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    AlmostSorted sol1  = new AlmostSorted();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        int index4 = -1;
        int[] a = new int[n];
        for (int i = 0 ;i < n ; i++)
            a[i] = sc.nextInt();
        
        boolean ans = false;
        for (int i = 0; i < n-1 ; i++) {
            if (a[i+1] < a[i] && index1 == -1)
                index1 = i;
            else if (a[i+1] < a[i] && index3 == -1)
                index3 = i;
            else if (a[i+1] < a[i]) {
                ans = true;
                break;
            }
            boolean flag = false;
            while (i<n-1 && a[i+1] < a[i]) {
                flag  = true;
                i++;
            }
            if (flag == true && index2 == -1)
                index2 = i;
            else if (flag == true && index4 == -1)
                index4 = i;
        }
        if (index1 == -1 && index2 == -1 && index3 == -1 && index4 == -1) {
            System.out.println("yes");
            return;
        }
        //System.out.println(index1 + "  " + index2 + "  " + index3 + "  " + index4);
        if (ans == true)
            System.out.println("no");
        else {
            boolean print = false;
            if (print == false && index4 == index2 ) {
                if (a[index4] <= a[index1+1] && a[index1] >= a[index4-1]) {
                    System.out.println("yes");
                    print  = true;
                    System.out.println("swap " + (index1+1) + " " + (index4+1));
                }
           }
           if (print == false && index2 <= index1 + 2 ) {
               if (index2 == index1 +1) {
                   if ((index2 +1 < n && a[index1] <= a[index2+1]) || index2+1>=n) {
                       System.out.println("yes");
                       print = true;
                        System.out.println("swap " + (index1+1)+ " " + (index2+1));
                    }
               }
               else {
                   if (a[index2] <= a[index1+1] && a[index1] >= a[index2-1]) {
                       System.out.println("yes");
                       print = true;
                        System.out.println("swap " + (index1+1)+ " " + (index2+1));
                   }
               }
           }
           else if (print == false && index3 == -1 && index4 == -1) {
               if (a[index2] <= a[index1+1] && a[index1] >= a[index2-1]) {
                   System.out.println("yes");
                   System.out.println("reverse " + (index1+1) + " " + (index2+1));
                   print = true;
               }
           }
           if (print == false && index3 != -1 && index4 != -1 && a[index4] <= a[index1+1] && a[index1] >= a[index4-1]) {
               System.out.println("yes");
               print = true;
               System.out.println("swap " + (index1+1)+ " " + (index4+1));
           }
            if (print  == false) {
                System.out.println("no");
            }
        }
    }
}