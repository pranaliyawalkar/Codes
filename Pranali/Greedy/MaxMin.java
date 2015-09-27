import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class MaxMin {
    
   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
      int K = Integer.parseInt(in.readLine());
      int[] list = new int[N];

      for(int i = 0; i < N; i ++)
         list[i] = Integer.parseInt(in.readLine());
      
      int unfairness = process(N, K, list);
      
      /*
       * Write your code here, to process numPackets N, numKids K, and the packets of candies
       * Compute the ideal value for unfairness over here
      */
      
      System.out.println(unfairness);
   }
    
    public static int process(int n, int k, int[] num) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n ; i++) {
            if (i+k-1 >=n )
                break;
            int diff = num[i+k-1] - num[i];
            if (diff < min) {
                min = diff;
            }
        }
        return min;
        
    }
}
