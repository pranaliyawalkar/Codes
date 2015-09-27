#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int t;
	cin >> t;
	for(int iter = 0; iter < t; iter++){
		int n, grid[2][20]={0}, dp[20]={0}, flag = 0;
		cin >> n;
		string str1, str2;
		cin >> str1 >> str2;
		for(int i = 0; i < n; i++){
			grid[0][i] = str1.at(i)-'0';
			grid[1][i] = str2.at(i)-'0';
		}
		for(int i = 0; i < n; i++){
			dp[i] = grid[0][i]+grid[1][i];
			if(dp[i]==2){
				dp[i] = 0;
				if(i-1 >= 0 && dp[i-1]%2 != 0){
					flag = 1;
					break;
				}
				continue;
			}
			if(i-1 >= 0)
				dp[i] += dp[i-1];
		}
		if(flag == 1 || dp[n-1]%2 != 0){
			cout << "NO" << endl;
			continue;
		}
		for(int i = 0; i < n; i++){
			if(grid[0][i]==1 && (i-1>=0 && grid[1][i-1]==1) && dp[i-1]%2 != 0){
				flag = 1;
				break;
			}
		}
		if(flag == 0)
			cout << "YES" << endl;
		else
			cout << "NO" << endl;
	}
	return 0;
}
