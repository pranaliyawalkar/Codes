import java.util.ArrayList;

//To get all prime numbers less than n

public class PrimeNumbers {
	int n;
	public static void main (String[] args) {
		PrimeNumbers pn = new PrimeNumbers();
		pn.n = 90000000;
		ArrayList<Integer> ans = pn.get_primes();
		//System.out.println(ans);
	}
	public ArrayList<Integer> get_primes() {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (n < 2)
			return ans;
		if (n == 2) {
			ans.add(2);
			return ans;
		}
		boolean[] arr = new boolean[n];
		for (int i = 3; i < n; i = i+2) {
			if (arr[(i/2)-1] == false) {
				ans.add(i);
				mark_multiples(arr, i);
			}
		}
		return ans;
	}
	public void mark_multiples(boolean[] arr, int value) {
		for (int i = 3;  i*value <= n; i=i+2) {
			arr[(i*value)/2 - 1] = true;
		}
	}
}
