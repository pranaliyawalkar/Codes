MarkAndToys.java : 
	Answer : Maximise no. of toys bought in K rupees
	Solution : Greedy. Sort toys on price

JimAndTheOrders.java :
	Answer : Each burger has a start time and time taken to cook. Find order of processing the burgers
	Solution : sort based on finish time

GridChallenge.java : 
	Answer : Is it possible to arrange a grid so that every row and column is sorted. Only operation allowed is swap G[i][j] and G[i][j+1]
	Solution : sort each row. Swapping elements is equivalent to being able to sort.

MaxMin.java : 
	Answer : Select k numbers such that max - min is minimised
	Solution : Sort

TeamFormation.java : 
	Answer : Form teams such that size of smallest team is largest possible
	Solution : gen

CuttingBoards.java : gen greedy

PriyankaAndToys.java : gen greedy

Flowers.java : gen greedy

TwoArrays.java : gen greedy

LargestPermutation.java : 
	Answer : the lexicographically largest permutation you can make with at most K swaps.

AlgorithmicCrush.java : 
	Answer : You are given a list of size N, initialized with zeroes. You have to perform M queries on the list and output the maximum of final values of all the N elements in the list. For every query, you are given three integers a, b and k and you have to add value k to all the elements ranging from index a to b(both inclusive)
	Solution : given a b k add k to index a and add -k to index (b+1). By doing this kind of update ith number in array will be prefix sum of array from index 1 to i.

ChiefHopper.java : 
	Answer : If hk+1>botEnergy, then he will lose hk+1−botEnergy units of energy. Otherwise, he will gain botEnergy−hk+1 units of energy. Find min energy to start with
	Solution : fact when you reach the last building your energy can be at least 0. which means suppose last height is `hn` your energy at `hn−1` must be greater than or equal to `hn/2`

SherlockAndMiniMax.java : 
	Answer : Given an array A1,A2...AN. find an integer M between P and Q(both inclusive), such that, min {|Ai-M|, 1 ≤ i ≤ N} is maximised
	SOlution : Check for all pairs of Ai and Aj. Answer must be (Ai + Aj)/2. Or do binary search and iterate between that range.
