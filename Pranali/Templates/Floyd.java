// All pairs shortest path
/*Sample input : 
 * 4 5
1 2 5
1 4 24
2 4 6
3 4 4
3 2 7
 * 
 */
import java.util.*;

public class Floyd {
	public static void main(String[] args) {
		Floyd fl = new Floyd();
		fl.process();
	}
	
	public void process() {
		Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dist = new int[n][n];
        for (int i = 0 ;i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if (i != j)
                    dist[i][j] = 9999999;
            }
        }
        for (int i = 0; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a--;
            b--;
            dist[a][b] = c;
        }
        for (int k = 0;k <n ; k++) {
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < n ; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        //dist[a][b] = shortest distance between them
	}
}
