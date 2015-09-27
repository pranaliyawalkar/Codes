SherlockAndAnagrams.java : 
	Answer : Finding anagramic pairs of substrings
	Solution : compute xor of numbers from 0 to i, for every i; iterate over all length substrings and all starting points. If xor of two substrings is same, see if the strings are anagrams too (sort and check)

BiggerIsGreater.java : 
	Answer : Rearrange letters of a word to form smallest lexicographically greater word
	Solution : Find the point till where the string is increasingly. Exchange that point with the higher one and reverse print till that point

CommonChild.java :
	Answer : Longest String which is a child of two inputs strings. Child string can be generated from parent by deleting 0 or more charcs
	Solution : Longest Common Subsequence

Anagram.java : gen

TwoStrings.java : gen

PalindromeIndex.java : 
	Answer : You are given a string of lower case letters. Your task is to figure out the index of the character on whose removal it will make the string a palindrome
	Solution : One can do so by checking if str[i] == str[N - 1 - i] where N is the length of the string for all i starting from i = 0. Once this condition fails, all we have to do is to check if str[0:i-1] + str[i+1:N-1] is a palindrome and print i if it is so, otherwise print N - i - 1.