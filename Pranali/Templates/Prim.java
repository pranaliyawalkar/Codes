import java.util.*;

//Finding the K-mst
/* Sample input : 
 * 5 6
1 2 3
1 3 4
4 2 6
5 2 2
2 3 5
3 5 7
Sample output : 15
 */

class edg {
    int end;
    int w;
}

class edge_comp implements Comparator<edg> {
    public int compare (edg e1, edg e2) {
        return e1.w - e2.w;
    }
}

public class Prim {
	
	public static void main(String[] args) {
		Prim pm = new Prim();
		pm.process();
	}
	public void process() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<edg>> ad = new ArrayList<ArrayList<edg>>();
        for (int i = 0; i < n ; i++)
            ad.add(new ArrayList<edg>());
        PriorityQueue<edg> pq = new PriorityQueue<edg>(10, new edge_comp());
        for (int i = 0 ; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a = a-1;
            b = b-1;
            edg e1 = new edg();
            e1.end = b;
            e1.w = c;
            edg e2 = new edg();
            e2.end = a;
            e2.w = c;
            ad.get(a).add(e1);
            ad.get(b).add(e2);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int i = 0; i < ad.get(0).size(); i++) {
        	pq.add(ad.get(0).get(i));
        }
        int count = 0;
        
        while (pq.size() > 0) {
        	edg e1 = pq.poll();
        	if (visited[e1.end] == true)
        		continue;
        	count += e1.w;
        	visited[e1.end] = true;
        	for (int i = 0; i < ad.get(e1.end).size(); i++) {
        		if (visited[ad.get(e1.end).get(i).end] == false) {
        			pq.add(ad.get(e1.end).get(i));
        		}
        	}
        }
        
        System.out.println(count);
	}

}
