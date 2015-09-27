#include "iostream"
#include <string>
#include <sstream>
#include <vector>
#include <stdio.h>
#include <algorithm>
#include <math.h>
#include <iterator>
using namespace std;

long long dp[2][100001];

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	for(int iter = 1; iter <= t; iter++){
		long long n, k;
		cin >> n >> k;
		for(int i = 1; i <= n; i++){
			dp[1][i] = i;
			dp[0][i] = 1;
		}
		for(int i = 2; i <= k-1; i++){
			dp[i%2][1] = 1;
			for(int j = 2; j <= n; j++){
				dp[i%2][j] = 0;
				for(int l = j; l >= 1; l--)
					dp[i%2][j] += dp[(i+1)%2][l];
			}
		}
		for(int i = 1; i <= n; i++){
			cout << dp[(k-1)%2][i] << " " ;
		}
		cout << endl;
		int s = dp[(k-1)%2][n];
		while(n){
			for(int i = 0; i < s; i++){
				long long temp;
				cin >> temp;
				if(i == 0)
					cout << (temp/k) << " ";
			}
			n--;
			s = dp[(k-1)%2][n];
		}
		cout << endl;
	}
	return 0;
}