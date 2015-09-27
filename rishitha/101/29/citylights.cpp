#include "iostream"
using namespace std;

struct node
{
	int dest;
	int light;
};

class Graph
{
public:
	int n;
	std::vector<node> adj[500003];
public:
	Graph(int v){
		n = v;
	}
	void addEdge(int src, int dest, int light, int light1){
		struct node newNode;
		newNode.dest = dest;
		newNode.light = light;
		adj[src].push_back(newNode);
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


int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	for(int i = 0; i < t; i++){
		int n;
		bool l[500001];
		cin >> n;
		Graph g(n);
		for(int i = 0; i < n; i++){
			cin >> l[i];
		}
		for(int i = 0; i < n-1; i++){
			int u, v;
			cin >> u >> v;
			g.addEdge(u-1, v-1, l[u-1], l[v-1]);
		}
	}
	return 0;
}