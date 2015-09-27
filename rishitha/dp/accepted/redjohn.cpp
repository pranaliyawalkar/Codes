#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int t, dp[41], primes[41];
	cin >> t;
	dp[0] = 1;
	for(int i = 1; i <= 40; i++){
		if(i < 4)
			dp[i] = dp[i-1];
		else
			dp[i] = dp[i-1]+dp[i-4];
	}
	int m = dp[40];
	int mark[220000] = {0}, n = 0;
	for(int i = 2; i <= m; i++){
		if(mark[i] == 0){
			for(int j = i+i; j < 220000; j = j+i)
				mark[j] = 1;
		}
		
	}
	for(int i = 0; i < t; i++){	
		int n, ans = 0;
		cin >> n;
		for(int j = 2; j <= dp[n]; j++){
			if(mark[j] == 0)
				ans++;
		}
		cout << ans << endl;
	}
	return 0;
}
