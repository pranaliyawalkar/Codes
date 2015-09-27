#include "iostream"
#include <limits.h>
using namespace std;

char a[52][52];
int dp[52][52][1001];

int main(int argc, char const *argv[])
{
	int n, m, k, fi, fj;
	cin >> n >> m >> k;
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cin >> a[i][j];
			if(a[i][j] == '*'){
				fi = i; fj = j;
			}
		}
	}
	for(int i = 0; i < n; i++)
		for(int j = 0; j < m; j++)
			dp[i][j][0] = INT_MAX/2;
	dp[0][0][0] = 0;
	for(int t = 1; t <= k; t++){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				int x1 = INT_MAX/2, x2 = INT_MAX/2, x3 = INT_MAX/2, x4 = INT_MAX/2;
				if(i-1 >= 0){ 
					x1 = (a[i-1][j] == 'D') ? 0 : 1;
					x1 += dp[i-1][j][t-1];
				}
				if(i+1 < n){ 
					x2 = (a[i+1][j] == 'U') ? 0 : 1;
					x2 += dp[i+1][j][t-1];
				}
				if(j-1 >= 0){ 
					x3 = (a[i][j-1] == 'R') ? 0 : 1;
					x3 += dp[i][j-1][t-1];
				}
				if(j+1 < m){ 
					x4 = (a[i][j+1] == 'L') ? 0 : 1;
					x4 += dp[i][j+1][t-1];
				}
				dp[i][j][t] = min(x1, min(x2, min(x3, x4)));
			}
		}
	}
	int ans = INT_MAX/2;
	for(int i = 0; i <= k; i++){
		if(ans > dp[fi][fj][i])
			ans = dp[fi][fj][i];
	}
	if(ans == INT_MAX/2)
		cout << "-1" << endl;
	else
		cout << ans << endl;
	return 0;
}