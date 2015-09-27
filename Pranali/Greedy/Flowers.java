/* Sample program illustrating input/output methods */
import java.util.*;

class Flowers{
   public static void main( String args[] ){
      
// helpers for input/output      

      Scanner in = new Scanner(System.in);
      
      int N, K;
      N = in.nextInt();
      K = in.nextInt();
      
      int C[] = new int[N];
      for(int i=0; i<N; i++){
         C[i] = in.nextInt();
      }
      
      Arrays.sort(C);
      int flower_count = 0;
      int total = 0;
      int iter_count = 0;
      int i = N-1;
      while(i >=0) {
          while (iter_count < K && i>=0) {
              total += C[i] * (flower_count+1);
              iter_count++;
              i--;
          }
          iter_count = 0;
          flower_count++;
      }
      System.out.println( total );
      
   }
}
