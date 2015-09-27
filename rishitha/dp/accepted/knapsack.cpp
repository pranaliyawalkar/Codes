#include "iostream"
using namespace std;

int dp[2001][2001];

int main(int argc, char const *argv[])
{
	/* code */
	int t;
	cin >> t;
	for(int iter = 0; iter < t; iter++){
		int n, k, a[2001];
		cin >> n >> k;
		for(int j = 0; j < n; j++){
			cin >> a[j];
		}
		for (int i = 0; i <= k; ++i)
			dp[0][i] = 0;
		for (int i = 0; i <= n; ++i)
			dp[i][0] = 0;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= k; j++){
				dp[i][j] = dp[i-1][j];
				if(j-a[i-1] >= 0)
					dp[i][j] = max(dp[i][j], a[i-1]+dp[i][j-a[i-1]]);
			}
		}
		cout << dp[n][k] << endl;
	}
	return 0;
}