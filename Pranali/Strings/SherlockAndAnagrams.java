import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    SherlockAndAnagrams sol1 = new SherlockAndAnagrams();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String temp = sc.nextLine();
        for (int t = 0; t < T; t++) {
        	String s = sc.nextLine();
        	int n = s.length();
            BigInteger[] num = new BigInteger[n+1];
            BigInteger[] xor = new BigInteger[n+1];
            xor[0] =  BigInteger.ZERO;
            for (int i = 1;i < n+1; i++) {
            	String str = "1";
            	/*char[] chars = new char[((int)s.charAt(i-1))-97];
            	Arrays.fill(chars, '0');
            	String te = new String(chars);
            	str = str + te;*/
                num[i] = get_big(((int)s.charAt(i-1))-97) ;
                if (i > 0)
                	xor[i] = xor[i-1].xor(num[i]);
                else 
                	xor[i] = num[i];
            }
            int count = 0;
            for (int len = 1; len <= n; len++) {
            	for (int i = 0;i < n && i+len<=n ; i++) {
                    for (int j = i+1; j <n && j+len<=n ; j++) {
                    	BigInteger a1 = xor[i].xor(xor[i+len]);
                    	BigInteger a2 = xor[j].xor(xor[j+len]);
                    	if (a1.compareTo(a2) == 0) {
                    		//System.out.println(sort(s.substring(i+1, i+len)) + "  " + sort(s.substring(j+1, j+len)));
                    		String s1 = sort(s.substring(i, i+len));
                    		String s2 = sort(s.substring(j, j+len));
                    		if (s1.equals(s2)) {
                    			//System.out.println("fucked");
                    			count++;
                    			//System.out.println(s1 + "  " + s2);
                    			
                    		}
                    	}
                    }
                }
            }
            System.out.println(count);
        }
        
    }
    public BigInteger get_big(int x) {
    	BigInteger ans = BigInteger.ONE;
    	for (int i = 0; i < x; i++)
    		ans = ans.multiply(new BigInteger("2"));
    	return ans;
    }
    public String sort (String s) {
    	char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
}