ManasaAndStones.java
	Answer : Possible values of the last element if consecutive elements have difference of a or b
	Solution : find max, find min, keep removing b from max and adding a to max till we reach min

FindMedian.java : 
	Answer : median of elements read so far in data strea
	Solution : Maintain two heaps, one of smaller elements, one of larger. Median = largest of smaller + smallest of larger /2 if sizes of the heaps are same. Else the one from the bigger size. Push accordingly so that the heap variant remains same. 

LowestCommonAncestor.java :
	Answer : LCA in binary search tree
	Solution : 
		if(root.data >= v1 && root.data <= v2)
            return root;
        else if (root.data < v1 && root.data < v2)
            return lca(root.right, v1, v2);
        else if (root.data > v1 && root.data > v2)
            return lca(root.left, v1, v2);
        return root;

