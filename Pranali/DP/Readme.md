PlayWithWords.java : 
	Answer : max (Product of 2 disjoint palindromic subsequences)
	Solution : 2D DP , split at every i to find longest palindrome on each side

Equal.java : 
	Answer : To equal the number of chocs distributed by giving 1, 2, 5 chocs to others but the chosen one. Minimum no. of operations needed
	Solution : Giving to others but chosen one ~ reducing the chosen one. minimum(Bringing each one down to (min, min-1, min-2, min-3, min-4, min-5))

LongestCommonSubsequence.java : DP

CoinChange.java : 
	Answer : number of ways to generate a sum from given set of coins
	Solution : every coin can be present many times, or absent

Candies.java : gen

RedJohnIsBack.java : 
	Answer : No. of ways to geenrate 4*N wall with 4* and 1*4 bricks
	Solution : DP + recursion 

FibonacciModified.java : gen

SamAndSubstrings.java : 
	Answer : substrings of 123 are 1, 2, 3, 12, 23, 123 which sums to 164. Mod with huge number
	Solution : 5312 : 5 | 3 53 | 1 31 531 | 2 12 312 5312. 
	sd[0] holds the sum of all digits that ends at N[0] = 5 
	sd[1] holds the sum of all digits that ends at N[1] = 3 
	sd[2] holds the sum of all digits that ends at N[2] = 1 
	sd[3] holds the sum of all digits that ends at N[3] = 2
	S = sd[0] + sd[1] + sd[2] + sd[3] 
	sd[i+1] = (i + 2) * N[i] + 10 * sd[i]
	sd[0] = N[0]
	Do modulo at every step. Modulo is additive.

BricksGame.java : 
	Answer : You and your friend decide to play a game using a stack consisting of N bricks. In this game, you can alternatively remove 1, 2 or 3 bricks from the top, and the numbers etched on the removed bricks are added to your score. You have to play so that you obtain the maximum possible score. It is given that your friend will also play optimally and you make the first move. Eg 0 1 1 1 999 : best option will be to pick up the first brick (with 0 score) at first. Then your friend will choose the next three blocks, and you will get the last brick.
	Solution : dp[k] = Prefix sum array : sum[i] = a[0] + a[1] + ....+ a[i] . Answer = max {(sum[k-1] - dp[k-1]) + a[k] ,(sum[k-2] - dp[k-2]) + a[k]+ a[k-1], (sum[k-3] - dp[k-3]) + a[k]+ a[k-1] +a[k-2] }. Or : 
	a = new BigInteger(num[index] + "");
	a = a.add(min(process2(index + 2), process2(index + 3), process2(index + 4))); //opponent leaving me with min optimal value always
	b = new BigInteger(num[index] + num[index + 1] + "");
	b = b.add(min(process2(index + 3), process2(index + 4), process2(index + 5)));  //opponent leaving me with min optimal value always
	c = new BigInteger(num[index] + num[index + 1] + num[index + 2] + "");
	c = c.add(min(process2(index + 4), process2(index + 5), process2(index + 6)));  //opponent leaving me with min optimal value always
	f[index] = max (a, b, c); //choosing max possible

TheMaximumSubarray.java : 
	Answer : Contiguous and non-contiguous maximum possible sum
	Solution : 
		1. Contiguous : Kadane algo
			for (int i = 0; i < n; i++) {
	            max_ending_here += num.get(i);
	            if(max_ending_here < 0)
	                max_ending_here = 0;
	            if (max_till_now < max_ending_here)
	                max_till_now = max_ending_here;
        	}
        	return max_till_now;
		2. Non : all +ve elements, else least negative element