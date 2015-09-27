#include "iostream"
using namespace std;

void count(int node){
	if(mark[node] == 1)
		return;
	
}

int main(int argc, char const *argv[])
{
	int n, m, v, u;
	cin >> n >> m;
	for(int i = 0; i < m; i++){
		cin >> u >> v;
		graph[u][v] = graph[v][u] = 1;
	}
	count(1);
	return 0;
}