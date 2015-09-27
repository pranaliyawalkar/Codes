#include "iostream"
#include <limits.h>
using namespace std;

void floydWarshall(int a[401][401], int n){
	int distance[401][401];
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			if(a[i][j] > 0 || i == j)
				distance[i][j] = a[i][j];
			else
				distance[i][j] = INT_MAX;
		}
	}
	for(int k = 0; k < n; k++){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(distance[i][k] != INT_MAX && distance[k][j] != INT_MAX && distance[i][j] > distance[i][k]+distance[k][j]){
					distance[i][j] = distance[i][k]+distance[k][j];
				}
			}
		}
	}
	int q, at, bt;
	cin >> q;
	for(int i = 0; i < q; i++){
		cin >> at >> bt;
		if(distance[at-1][bt-1] == INT_MAX)
			cout << "-1" << endl;
		else
			cout << distance[at-1][bt-1] << endl;
	}
}

int main(int argc, char const *argv[])
{
	int n, a[401][401] = {0}, x, y, z, m;
	cin >> n >> m;
	for(int i = 0; i < m; i++){
		cin >> x >> y >> z;
		a[x-1][y-1] = z;
	}
	floydWarshall(a, n);
	return 0;
}