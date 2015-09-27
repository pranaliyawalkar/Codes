#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int t, a[50001], mark[50001];
	cin >> t;
	for(int i = 0; i < t; i++){
		int n;
		cin >> n;
		for(int j = 0; j < n; j++)
			cin >> a[j];
		int maximum = -1, index = -1;
		int j = 0;
		while(j < n){
			maximum = -1;
			for(int k = j; k < n; k++){
				if(maximum < a[k]){
					maximum = a[k];
					index = k;
				}
			}
			for(; j <= index; j++){
				mark[j] = maximum;
			}
		}
		long long ans = 0;
		for(j = 0; j < n; j++){
			int temp = mark[j]-a[j];
			if(temp > 0)
				ans += temp;
		}
		cout << ans << endl;
	}
	return 0;
}
