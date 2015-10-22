import java.util.*;

// Eulerian Path is a path in graph that visits every edge exactly once
/*
 * 1. strongly connected graph (strong connectivity for an undirected graph is simply DFS and seeing if all nodes visited or not. 
 * For directed graph, we need to know if every node is reachable from every other node). 
 * The idea is, if every node can be reached from a vertex v, and every node can reach v, then the graph is strongly connected.
 * 2. in degree = out degree of every node 
 * 3. All vertices of non 0 degree belong to strongly connected component
 * Sample input : 
 * 4 4
 * 1 2
 * 2 3
 * 3 4
 * 4 1
 * Sample output : Yes
 */
public class Euler {
	int n;
	int m;
	ArrayList<ArrayList<Integer>> ad = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		Euler el = new Euler();
		el.process();
	}
	public void process() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			ad.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			a--;
			b--;
			ad.get(a).add(b);
		}
		boolean ans = check_euler();
		System.out.println(ans);
	}
	
	public boolean check_euler() {
		boolean visited[] = new boolean[n];
		//finding first vertex with non0 degree 
		int node = 0;
		for (int i = 0; i < n ; i++) {
			if (ad.get(i).size() > 0) {
				node = i;
				break;
			}
		}
		//does node reach every other node
		dfs(node, visited);
		for (int i = 0; i < n ; i++) {
			if (ad.get(i).size() > 0 && visited[i] == false)
				return false;
		}
		
		//reverse the graph
		ArrayList<ArrayList<Integer>> rev = reverse();
		ad.clear();
		ad.addAll(rev);
		visited = new boolean[n];
		
		//is node reachable from every other node
		dfs(node, visited);
		for (int i = 0; i < n ; i++) {
			if (ad.get(i).size() > 0 && visited[i] == false)
				return false;
		}
		return true;
			
	}
	
	public void dfs(int start, boolean[] visited) {
		visited[start] = true;
		for (int i = 0; i < ad.get(start).size(); i++) {
			if (visited[ad.get(start).get(i)] == false) {
				dfs(ad.get(start).get(i), visited);
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> reverse() {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n ; i++)
			ans.add(new ArrayList<Integer>());
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < ad.get(i).size(); j++) {
				ans.get(ad.get(i).get(j)).add(i);
			}
		}
		return ans;
	}
}
