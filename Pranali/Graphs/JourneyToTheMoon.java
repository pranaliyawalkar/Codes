import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class JourneyToTheMoon {
    ArrayList<ArrayList<Integer>> ad;
    boolean[] visited;
    int n;
    int m;
    
   public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        JourneyToTheMoon sol1 = new JourneyToTheMoon();
        String[] temp = bfr.readLine().split(" ");
       
        sol1.n = Integer.parseInt(temp[0]);
        sol1.m = Integer.parseInt(temp[1]);
      
        sol1.ad = new ArrayList<ArrayList<Integer>>();
       for (int i = 0; i < sol1.n; i++)
           sol1.ad.add(new ArrayList<Integer>());
        for(int i = 0; i < sol1.m; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            sol1.ad.get(a).add(b);
            sol1.ad.get(b).add(a);
            
        }

        sol1.ans();
        //long combinations = sol1.ans();

        // Compute the final answer - the number of combinations
       
        //System.out.println(combinations);

   }
    public void ans() {
        visited = new boolean[n];
        ArrayList<Long> answers = new ArrayList<Long>();
        while (true) {
            boolean flag = false;
            for (int i = 0;i < n ; i++) {
                if (visited[i] == false) {
                    flag  = true;
                    answers.add(dfs(i));
                }
            }
            if (flag == false)
                break;
        }
        BigInteger ans = BigInteger.ZERO;
        ans = new BigInteger (n + "").multiply(new BigInteger(n-1 + ""));
        ans = ans.divide(new BigInteger("2"));
        long subtract = 0;
        for (int i = 0; i < answers.size() ; i++) {
            subtract += ((answers.get(i) * (answers.get(i) - 1))/2);
        } 
        ans = ans.subtract(new BigInteger(subtract + ""));
        /*for (int i = 0;i < answers.size() ; i++) {
            for (int j = i+1;j < answers.size() ; j++) {
                ans = ans + (answers.get(i)*answers.get(j));
            }
        }*/
        System.out.println(ans);
    }
    public long dfs(int root) {
        visited[root] = true;
        long ans = 1;
        for (int i = 0; i < ad.get(root).size(); i++) {
            if (visited[ad.get(root).get(i)] == false) {
                ans = ans + dfs(ad.get(root).get(i));
            }
        }
        return ans;
    }
}
