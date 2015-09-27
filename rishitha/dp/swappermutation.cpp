#include "iostream"
using namespace std;

long long dp1[2501][2501];
long long dp2[2501][2501];

int main(int argc, char const *argv[])
{
	int n, k;
	cin >> n >> k;
	long long ans2 = 0;
	for(int i = 0; i <= k; i++)
		dp1[1][i] = dp1[2][i] = dp2[1][i] = dp2[2][i] = 1;
	for(int i = 3; i <= n; i++){
		dp1[i][0] = 1;
		for(int j = 1; j <= k; j++){
			for(int l = j; l >= (j-i+1); l--)
				dp1[i][j] = (dp1[i][j]+dp1[i-1][l])%1000000007;
		}
	}
	for(int i = 2; i <= n; i++){
		dp2[i][0] = 1;
		for(int j = 1; j <= k; j++)
			dp2[i][j] = (dp2[i-1][j]+(dp2[i-1][j-1]*(i-1)))%1000000007;
	}
	cout << (dp1[n][k]%1000000007) << " " << dp2[n][k] << endl;
	return 0;
}