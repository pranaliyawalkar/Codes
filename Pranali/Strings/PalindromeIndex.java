import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PalindromeIndex {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PalindromeIndex sol1 = new PalindromeIndex();
        sol1.process(); 
    }
    public void process() {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        String temp = s.nextLine();
        for (int t = 0; t <T; t++) {
            String str = s.nextLine();
            int i = 0;
            int j = str.length() -1 ;
            boolean flag = false;
            boolean flag2 = false;
            int temp1 = 0;
            int temp2 = 0;
            while (true ) {
                if (i == j-1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        if (flag == false)
                            System.out.println(-1);
                        break;
                    }
                }
                if (i ==j) {
                    if (flag == false) 
                        System.out.println(-1);
                    break;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    i++;
                    j--;
                    continue;
                }
                else {
                    if (flag == true) {
                        flag2 = true;
                        System.out.println(temp2);
                        break;
                    }
                    if ((str.charAt(i) == str.charAt(j-1)) && (str.charAt(i+1) != str.charAt(j))) {
                        System.out.println(j);
                        break;
                    }
                    else if (str.charAt(i+1) == str.charAt(j) && (str.charAt(i) != str.charAt(j-1))) {
                        System.out.println(i);
                        break;
                    }
                    else if (str.charAt(i+1) == str.charAt(j) && (str.charAt(i) == str.charAt(j-1))) {
                        flag = true;
                        temp1 = i;
                        temp2 = j;
                        i++;
                    }
                }
            }
            if (flag == true && flag2 == false) {
                System.out.println(temp1);
            }
        }
    }
}
