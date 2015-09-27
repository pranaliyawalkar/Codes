#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int n, a[1000001], dp[1000001], ans = 0;
	cin >> n;
	for(int i = 0; i < n; i++){
		cin >> a[i];
		dp[i] = 1;
		for(int j = 0; j < i; j++){
			if(a[j] < a[i])
				dp[i] = max(dp[j]+1, dp[i]);
		}
		if(ans < dp[i])
			ans = dp[i];
	}
	cout << ans << endl;
	return 0;
}
