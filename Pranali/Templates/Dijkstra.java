import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//To find shortest distance between 0 and every other node
/*Sample input : graph
4 4
1 2 24
1 4 20
3 1 3
4 3 12

Sample output : 24 3 15
*/

class edge {
	int dest_id;
	int weight;
}

class nod {
	int node_id;
	int dist;
}

class nod_comparator implements Comparator<nod> {
	public int compare(nod n1, nod n2) {
		return n1.dist - n2.dist;
	}
}

public class Dijkstra {
	int n;
	int m;
	ArrayList<ArrayList<edge>> ad;
	nod[] nodes;
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra();
		d.process();
	}
	public void process() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ad = new ArrayList<ArrayList<edge>>();
		nodes = new nod[n];
		for (int i = 0; i < n ; i++) {
			nodes[i] = new nod();
			nodes[i].node_id = i;
			nodes[i].dist = Integer.MAX_VALUE;
		}
		nodes[0].dist = 0;
		
		for (int i = 0; i < n; i++)
			ad.add(new ArrayList<edge>());
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			a--;
			b--;
			
			edge e1 = new edge();
			e1.dest_id = b;
			e1.weight = c;
			
			edge e2 = new edge();
			e2.dest_id = a;
			e2.weight = c;
			
			ad.get(a).add(e1);
			ad.get(b).add(e2);
		}
		dj();
		for (int i = 1; i < n; i++) {
			System.out.print(nodes[i].dist + " ");
		}
	}
	public void dj() {
		PriorityQueue<nod> pq = new PriorityQueue<>(10, new nod_comparator());
		pq.add(nodes[0]);
		while (pq.size() > 0) {
			nod top = pq.poll();
			ArrayList<edge> nei = ad.get(top.node_id);
			for (int i = 0; i < nei.size(); i++) {
				if (nodes[nei.get(i).dest_id].dist > top.dist + nei.get(i).weight) {
					nodes[nei.get(i).dest_id].dist = top.dist + nei.get(i).weight;
					pq.add(nodes[nei.get(i).dest_id]);
				}
			}
		}
	}
}
