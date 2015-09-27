#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int n, m, c[51];
	long long dp[52][252] = {0};
	cin >> n >> m;
	for(int i = 0; i < m; i++)
		cin >> c[i];
	for(int j = 0; j <= m; j++)
		dp[j][0] = 1;
	for(int j = 1; j <= m; j++){
		for(int k = 1; k <= n; k++){
			dp[j][k] = dp[j-1][k];
			if(k-c[j-1] >= 0)
				dp[j][k] += dp[j][k-c[j-1]];
		}
	}
	cout << dp[m][n] << endl;
	return 0;
}
