import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SamAndSubstrings {

    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        SamAndSubstrings sol1 = new SamAndSubstrings();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        BigInteger sum = BigInteger.ZERO;
        int len = s.length();
        BigInteger temp = BigInteger.ZERO;
        BigInteger modu = new BigInteger("1000000007");
        for (int i = 0; i < len; i++) {
            temp = temp.multiply(new BigInteger("10"));
            temp = temp.add(new BigInteger((i+1) + "").multiply(new BigInteger(s.charAt(i) + "")));
            temp = temp.mod(modu);
            sum = sum.add(temp);
        }
        System.out.println(sum.mod(modu));   
    }
}