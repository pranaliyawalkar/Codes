#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int n, m, a[101], b[101], dp[101][101];
	cin >> n >> m;
	dp[0][0] = 0;
	for(int i = 0; i < n; i++){
		cin >> a[i];
		dp[i+1][0] = 0;
	}
	for(int i = 0; i < m; i++){
		cin >> b[i];
		dp[0][i+1] = 0;
	}
	for(int i = 1; i <= n; i++){
		for(int j = 1; j <= m; j++){
			if(a[i-1] == b[j-1])
				dp[i][j] = dp[i-1][j-1]+1;
			else{
				dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
			}
			//cout << dp[i][j]
		}
	}
	int count = 0, i = n, j = m;
	int ans[101];
	while(i != 0 && j != 0){
		if(a[i-1] == b[j-1]){
			ans[count] = a[i-1];
			i--;
			j--;
			count++;
		}
		else{
			if(dp[i][j] == dp[i-1][j])
				i--;
			else
				j--;
		}
	}
	for(i = count-1; i >= 0; i--){
		cout << ans[i] << " ";
	}
	cout << endl;
	return 0;
}
