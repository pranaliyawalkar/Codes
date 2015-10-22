import java.util.ArrayList;

//generate permutations between 1 to n

public class Permutation {
	int n;
	public static void main(String[] args) { 
		Permutation p = new Permutation();
		p.process();
	}
	public void process() {
		n = 4;
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			num.add(i+1);
		}
		recur(num, new ArrayList<Integer>());
	}
	public void recur(ArrayList<Integer> num, ArrayList<Integer> ans) {
		if (ans.size() == n) {
			System.out.println(ans);
		}
		else {
			for (int i = 0; i < num.size(); i++) {
				int val = num.get(i);
				ans.add(val);
				num.remove(i);
				recur(num, ans);
				ans.remove(ans.size()-1);
				num.add(i, val);
			}
		}
	}
	
}
