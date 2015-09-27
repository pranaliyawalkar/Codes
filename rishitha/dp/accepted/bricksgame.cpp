#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int t, a[100001], len[100001];
	long long dp[100001];
	cin >> t;
	for(int i = 0; i < t; i++){
		int n;
		cin >> n;
		for(int j = 0; j < n; j++){
			cin >> a[n-j-1];
		}
		dp[0] = a[0]; dp[1] = a[0]+a[1]; dp[2] = a[0]+a[1]+a[2];
		len[0] = 1; len[1] = 2; len[2] = 3;
		for(int j = 3; j < n; j++){
			long long comp1 = -1, comp2 = -1, comp3 = -1;
			if(j-1-len[j-1] >= 0)
				comp1 =  a[j]+dp[j-1-len[j-1]];
			else
				comp1 = a[j];
			if(j-2-len[j-2] >= 0)
				comp2 = a[j]+a[j-1]+dp[j-2-len[j-2]];
			else
				comp2 = a[j]+a[j-1];
			if(j-3-len[j-3] >= 0)
				comp3 = a[j]+a[j-1]+a[j-2]+dp[j-3-len[j-3]];
			else
				comp3 = a[j]+a[j-1]+a[j-2];
			if(comp1 >= comp2 && comp1 >= comp3){
				dp[j] = comp1;
				len[j] = 1;
			}
			else if(comp2 >= comp1 && comp2 >= comp3){
				dp[j] = comp2;
				len[j] = 2;
			}
			else{
				dp[j] = comp3;
				len[j] = 3;
			}
		}
		cout << dp[n-1] << endl;
	}
	return 0;
}
