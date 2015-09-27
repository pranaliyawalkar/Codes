#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int l, k;
	cin >> l >> k;
	int ans = -1;
	for(int i = l; i <= k; i++){
		for(int j = l+1; j <= k; j++){
			int temp = i^j;
			if(temp > ans)
				ans = temp;
		}
	}
	cout << ans << endl;
	return 0;
}
