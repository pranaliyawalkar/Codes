#include "iostream"
#include <vector>
#include <stdlib.h>
#include <limits.h>
using namespace std;

struct node
{
	int dest;
	int weight;
};

class Graph
{
public:
	int n;
	std::vector<node> adj[3003];
public:
	Graph(int v){
		n = v;
	}
	void addEdge(int src, int dest, int weight){
		struct node newNode;
		newNode.dest = dest;
		newNode.weight = weight;
		adj[src].push_back(newNode);

		// If undirected graph
		struct node newNode1;
		newNode1.dest = src;
		newNode1.weight = weight;
		adj[dest].push_back(newNode1);
	}

	void printGraph(){
		for(int i = 0; i < n; i++){
			cout << i << "-> "; 
			for(int j = 0; j < adj[i].size(); j++){
				struct node nodeTemp =  adj[i].at(j);
				cout << nodeTemp.dest << " " << nodeTemp.weight << "; ";
			}
			cout << endl;
		}
	}
};

/*struct minHeapNode
{
	int key;
	int node;
};

struct Comp
{
	bool operator()(const minHeapNode& s1, const minHeapNode& s2){
		return s1.key < s2.key;
	}
};

void primsMSTwithMinHeap(Graph g, int s){
	std::vector<minHeapNode> minHeap;
	int *mstSet = (int*) malloc((n+1)*sizeof(int));	//Set of vertices included in Minimum Spanning Tree
	int *key = (int*) malloc((n+1)*sizeof(int));
	int *parent = (int*) malloc((n+1)*sizeof(int));	//Array to store MST structure
	for(int i = 0; i < n; i++){
		struct minHeapNode newNode;
		if(i == s)
			newNode.key = 0;
		else
			newNode.key = INT_MAX;
		newNode.node = i;
		minHeap.push_back(newNode);
		mstSet[i] = -1;
	}
	make_heap(minHeap.begin(), minHeap.end(), Comp());
	int count = 0;
	parent[s] = -1;
	while(count != n){
		struct minHeapNode minNode = minHeap.front();
		int minWt = minNode.key;
		mstSet[minNode.node] = 1;
		count++;
		std::vector<node> l = g.adj[minNode.node];
		for(int i = 0; i < l.size(); i++){
			struct node nodetemp = l.at(i);
			if(key[nodetemp.dest] > nodetemp.weight && mstSet[nodetemp.dest] == -1){
				key[nodetemp.dest] = nodetemp.weight;
				parent[nodetemp.dest] = minNode.node;
			}
		}
	}
}*/

void primsMST(Graph g, int s){
	int n = g.n;
	int *mstSet = (int*) malloc((n+1)*sizeof(int));	//Set of vertices included in Minimum Spanning Tree
	int *key = (int*) malloc((n+1)*sizeof(int));	//Set of vertices not included in MST
	int *parent = (int*) malloc((n+1)*sizeof(int));	//Array to store MST structure
	for(int i = 0; i < n; i++){
		key[i] = INT_MAX;
		mstSet[i] = -1;
	}
	key[0] = 0; parent[0] = -1;
	int count = 0;
	long long ans = 0;
	while(count != n){
		int minWt = INT_MAX, minNode = -1;
		for(int i = 0; i < n; i++){
			if(minWt > key[i] && mstSet[i] == -1){
				minWt = key[i];
				minNode = i;
			}
		}
		ans += minWt;
		mstSet[minNode] = 1;
		count++;
		std::vector<node> l = g.adj[minNode];
		for(int i = 0; i < l.size(); i++){
			struct node nodetemp = l.at(i);
			if(key[nodetemp.dest] > nodetemp.weight && mstSet[nodetemp.dest] == -1){
				key[nodetemp.dest] = nodetemp.weight;
				parent[nodetemp.dest] = minNode;
			}
		}
	}
	cout << ans << endl;
}


int main(int argc, char const *argv[])
{
	int n, m, wt, src, dest, s;
	cin >> n >> m;
	Graph g(n);
	for(int i = 0; i < m; i++){
		cin >> src >> dest >> wt;
		g.addEdge(src-1, dest-1, wt);
	}
	cin >> s;
	primsMST(g, s-1);
	
	return 0;
}