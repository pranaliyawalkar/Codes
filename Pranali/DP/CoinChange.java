import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {

    ArrayList<ArrayList<BigInteger>> ans;
    ArrayList<Integer> coin;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        CoinChange sol1 = new CoinChange();
        sol1.process();
    }
    public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ans = new ArrayList<ArrayList<BigInteger>>();
        coin = new ArrayList<Integer>();
        ArrayList<BigInteger> init = new ArrayList<BigInteger>();
        for (int i = 0; i < m ;i++)
            init.add(BigInteger.ZERO);
        for(int i = 0; i <= n ; i++) {
            ArrayList<BigInteger> temp = new ArrayList<BigInteger>();
            temp.addAll(init);
            ans.add(temp);
        }
        for(int i = 0; i < m ; i++) {
            int val = sc.nextInt(); 
            coin.add(val);
        }
        for(int i = 0; i < m ; i++) {
            ans.get(0).set(i, BigInteger.ONE);
        }
        System.out.println(process2(n, m - 1));   
    }
    public BigInteger process2(int num, int count) {
        if (ans.get(num).get(count).compareTo(BigInteger.ZERO) > 0)
            return ans.get(num).get(count);
        BigInteger new_ans = BigInteger.ZERO;
        if (count > 0)
            new_ans = new_ans.add(process2(num, count-1));
        if (num - coin.get(count) >=0)
            new_ans = new_ans.add(process2(num - coin.get(count), count));
        ans.get(num).set(count, new_ans);
        return new_ans;
    }
}