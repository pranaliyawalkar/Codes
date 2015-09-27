#include "iostream"
using namespace std;

int dp[1501][1501];

int main (int argc, char const* argv[])
{
	int t;
	cin >> t;
	for(int iter = 0; iter < t; iter++){
		int s, n, ans = -1;
		string p, q;
		cin  >> s >> p >> q;
		n = p.size();
		dp[0][0] = 0;
		for(int i = 1; i <= n; i++){
			dp[i][0] = 0;
			for(int j = 1; j <= n; j++){
				dp[0][j] = 0;
				if(q.at(i-1) == p.at(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1+dp[i-1][j-1];
			}
		}
		int len = 1;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				int start = len-1;
				int end = min(n-i, n-j);
				for(int k = start; k <= end; k++){
					if(dp[i+k][j+k] - dp[i-1][j-1] <= s && len < (k+1))
						len = k+1;
					else if(dp[i+k][j+k] - dp[i-1][j-1] > s)
						break;
				}
			}
		}
		cout << len << endl;
	}
	return 0;
}
