//To find all prime factors of a number

import java.util.*;

public class PrimeFactors {
	int n;
	public static void main(String[] args) {
		PrimeFactors pf = new PrimeFactors();
		pf.n = 315;
		ArrayList<Integer> ans = pf.get_prime_factors();
		System.out.println(ans);
	}
	public ArrayList<Integer> get_prime_factors() {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while (n%2 == 0 && n > 0) {
			ans.add(2);
			n = n/2;
		}
		for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
			while (n %i == 0 && n > 0) {
				ans.add(i);
				n = n / i;
			}
		}
		if (n > 2)
			ans.add(n);
		return ans;
	}

}
