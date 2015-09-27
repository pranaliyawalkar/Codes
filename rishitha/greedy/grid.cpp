#include "iostream"
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	for(int i = 0; i < t; i++){
		int n dp[101][101], flag = 0;
		cin >> n;
		for(int j = 0; j < n; j++){
			string str;
			cin >> str;
			sort(str.being(), str.end());
			for(int k = 0; k < n; k++)
				dp[j][k] = str.at(k);
		}
		for(int j = 0; j < n; j++){
			for(int k = 1; k < n; k++){
				if(d[k][j] < dp[k-1][j]){
					flag = 1;
					break;
				}
			}
			if(flag == 1){
				break;
			}
		}
		if(flag == 1)
			cout << "NO\n";
		else
			cout << "YES\n";
	}
	return 0;
}