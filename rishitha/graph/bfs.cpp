#include "iostream"
#include <queue>
using namespace std;

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	for(int iter = 1; iter <= t; iter++){
		int n, m, graph[1001][1001] = {0}, s, mark[1001] = {0}, temp1, temp2;
		cin >> n >> m;
		for(int i = 0; i < m; i++){
			cin >> temp1 >> temp2;
			graph[temp1][temp2] = graph[temp2][temp1] = 6;
		}
		cin >> s;
		queue<int> q;
		q.push(s);
		mark[s] = -1;
		while(!q.empty()){
			int node = q.front();
			q.pop();
			for(int i = 1; i <= n; i++){
				if(graph[node][i] == 6 && mark[i] == 0){
					mark[i] = mark[node]+6;
					q.push(i);
				}
			}
		}
		for(int i = 1; i <= n; i++){
			if(i != s && mark[i] != 0)
				cout << (mark[i]+1) << " ";
			else if(i!=s && mark[i] == 0)
				cout << "-1 ";
		}
		cout << endl;
	}
	return 0;
}