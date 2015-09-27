#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int n, a[100001], c[100001];
	cin >> n;
	for(int i = 0; i < n; i++)
		cin >> a[i];
	c[0] = 1;
	for(int i = 1; i < n; i++){
		if(a[i] > a[i-1])
			c[i] = c[i-1]+1;
		else{
			c[i] = 1;
			for(int j = i-1; j >= 0; j--){
				if(a[j] > a[j+1])
					c[j] = max(c[j], c[j+1]+1);
				else
					break;
			}
		}
	}
	long long ans = 0;
	for(int i = 0; i < n; i++){
		ans = ans + c[i];
	}
	cout << ans << endl;
	return 0;
}
