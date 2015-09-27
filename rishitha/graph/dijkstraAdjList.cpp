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

void dijkstra(Graph a, int s){
	int n = a.n;
	int *spthSet = (int*) malloc(n*sizeof(int));	//Vertices included in shortest path tree
	int *distance = (int*) malloc(n*sizeof(int));	//distance from start node
	int *path = (int*) malloc(n*sizeof(int));		//shortest path tree
	for(int i = 0; i < n; i++){
		spthSet[i] = -1;
		distance[i] = INT_MAX;
	}
	distance[s] = 0;
	path[s] = -1;
	int count = 0;
	while(count != n){
		int nodeMin = -1, minWt = INT_MAX;
		for(int i = 0; i < n; i++){
			if(spthSet[i] == -1 && minWt > distance[i]){
				minWt = distance[i];
				nodeMin = i;
			}
		}
		if(nodeMin == -1)
			break;
		spthSet[nodeMin] = 1;
		count++;
		std::vector<node> l = a.adj[nodeMin];
		for(int i = 0; i < l.size(); i++){
			struct node temp = l.at(i);
			if(spthSet[temp.dest] == -1 && distance[temp.dest] > distance[nodeMin]+temp.weight){
				distance[temp.dest] = distance[nodeMin]+temp.weight;
				path[temp.dest] = nodeMin;
			}
		}
	}
	//distance from source
	for(int i = 0; i < n; i++){
		if(i == s)
			continue;
		if(distance[i] == INT_MAX){
			cout << "-1 ";
			continue;
		}
		cout << distance[i] << " ";
	}
	cout << endl;
}


int main(int argc, char const *argv[])
{
	int n, m, wt, src, dest, s;
	int t;
	cin >> t;
	for(int iter = 0; iter < t; iter++){
		cin >> n >> m;
		Graph g(n);
		for(int i = 0; i < m; i++){
			cin >> src >> dest >> wt;
			g.addEdge(src-1, dest-1, wt);
		}
		cin >> s;
		dijkstra(g, s-1);
	}
	return 0;
}