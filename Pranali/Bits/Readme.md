XorSubsequence.java : 
	Answer : Most frequent number among all subarrays where number is calculated by xor-ing all numbers in that subarray
	Solution : xor[subarray(i, j)] = xor[subarray(0, i)] ^ xor[subarray(0, j)]

XoringNinja.java : 
	Answer : Sum of all xor subsets. xor subset (x1, x2, x3) : x1 xor x2 xor x3
	Solution ans = 2.pow(n-1) * OR(all elements). There will be total 2^n subsets. If ith bit of any element is set, then that bit will be set in xor of half of the total subsets which is 2^(n-1). To find out all the set bits in all the numbers we find OR of all the numbers. Since each set bit appears in half of the total subsets we multiply OR of all numbers with 2^n-1 to get the final result.

ANDProduct.java : 
	Answer : compute the bitwise AND amongst all natural numbers lying between A and B
	Solution : If 2i is the most significant bit where A and B differ, then: 
		Every bit larger than 2i is present in the final answer if and only if it is present in A (and thus in B)
		Every bit smaller than or equal to 2i is not present in the answer.

MaximizingXOR.java : 
	Answer : Given two integers, L and R, find the maximal value of A xor B, where A and B satisfy the following condition: L≤A≤B≤R
	Solution : brute force

FlippingBits.java : 
	Answer : Integer obtained by flipping bits of input integer
	Solution : 2^32 - 1 - input_integer

LonelyInteger.java : 
	Answer : There are N integers in an array A. All but one integer occur in pairs. Your task is to find the number that occurs only once.
	Solution : xor all elements :)