#include "iostream"
#include "cmath"
using namespace std;

int max(int a, int b){
	if(a > b)
		return a;
	return b;
}

int main (int argc, char const* argv[])
{
	int t;
	cin >> t;
	for(int i = 0; i < t; i++){
		int n, a[100001];
		cin >> n;
		for(int j = 0; j < n; j++)
			cin >> a[j];
		int dp[100001][2];
		dp[0][0] = 0; dp[0][1] = 0;
		for(int j = 1; j < n; j++){
			dp[j][0] = max(dp[j-1][0], dp[j-1][1]+abs(a[j-1]-1));
			dp[j][1] = max(dp[j-1][0]+abs(a[j]-1), dp[j-1][1]+abs(a[j]-a[j-1]));
		}
		cout << max(dp[n-1][0], dp[n-1][1]) << endl;
	}
	return 0;
}
