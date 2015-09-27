#include "iostream"
using namespace std;

int dp[3001][3001];

int main (int argc, char const* argv[])
{
	string s;
	cin >> s;
	for(int i = 0; i < s.size(); i++)
		dp[i][i] = 1;
	int n = s.size();
	for(int len = 2; len <= n; len++){
		for(int i = 0; i < n-len+1; i++){
			int j = i+len-1;
			if(s.at(i) == s.at(j))
				dp[i][j] = 2+dp[i+1][j-1];
			else
				dp[i][j] = max(dp[i+1][j], dp[i][j-1]);
		}
	}
	long long ans = -1;
	for(int i = 0; i < n; i++){
		int temp = dp[0][i]*dp[i+1][n-1];
		if(ans < temp)
			ans = temp;
	}
	cout << ans << endl;
	return 0;
}
