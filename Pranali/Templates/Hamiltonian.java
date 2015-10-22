import java.util.ArrayList;
import java.util.Scanner;

/*
 * Backtracking
 * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. 
 * A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in graph) from the 
 * last vertex to the first vertex of the Hamiltonian Path
 * Sample graph : 
 5 7
 0 1
 0 3
 1 2
 1 3
 1 4
 2 4
 3 4
 sample output : yes
 */
public class Hamiltonian {
	int n;
	int m;
	ArrayList<ArrayList<Integer>> ad = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		Hamiltonian hm = new Hamiltonian();
		hm.process();
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
			ad.get(a).add(b);
			ad.get(b).add(a);
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(0);
		ArrayList<Integer> ans = check_hamil(0, temp );
		System.out.println(ans);
	}
	public ArrayList<Integer> check_hamil(int curr, ArrayList<Integer> path_seen) {
		if (path_seen.size() == n) {
			if (ad.get(0).contains(path_seen.get(path_seen.size()-1)))
				return path_seen;
			else
				return new ArrayList<Integer>();
		}
		for (int i = 0; i< ad.get(curr).size(); i++) {
			if (!path_seen.contains(ad.get(curr).get(i))) {
				path_seen.add(ad.get(curr).get(i));
				ArrayList<Integer> temp = check_hamil(ad.get(curr).get(i), path_seen);
				if (temp.size() == n)
					return temp;
				path_seen.remove(path_seen.size()-1);
			}
		}
		return new ArrayList<Integer>();
	}

}
