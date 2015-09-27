JackGoesToRapture.java : 
	Answer : fare (Node B) = fare(A,B) - total fare to reach station A
	Solution : Dijkstra modified to calculate shortest distance from current node to neighbors

JourneyToTheMoon.java :
	Answer : Need two people from two different countries, each country is a connected graph component
	Solution : Find connected component sizes, return nC2 - total pairs belonging to same country

Floyd.java : 
	Answer : All pairs shortest paths
	Solution : dist[i][j] = dist[i][k] + dist[k][j]; for all k

Dijkstra2.java : 
	Answer : Dist from S to all nodes
	Solution : Dijkstra

Kruskal.java : 
	Answer : Minimum spanning tree
	Solution : Sort edges, pick from the smallest as long as no cycle is formed. (cycle = there already exists a path between the nodes of the picked edges in our answer graph)

PrimMST.java : 
	Answer : MST
	Solution : take the minimum edge connecting a visited node and a unvisited node

EvenTree.java : 
	Answer : Split a tree into forests of trees each having even number of nodes
	Solution : Maintain a count of nodes under a node's subtree. If even, possible to remove
