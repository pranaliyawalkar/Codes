#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int t;
	cin >> t;
	for(int i = 0; i < t; i++){
		int n, flag = 0;
		long long ans1 = 0, ans2 = 0, current = 0, max = -99999;
		cin >> n;
		for(int j = 0; j < n; j++){
			int a;
			cin >> a;
			current += a;
			if(a > 0)
				flag = 1;
			if(current < 0)
				current = 0;
			else if(current > ans1)
				ans1 = current;
			if(a > 0)
				ans2 += a;
			if(max < a)
				max	= a;
		}
		if(flag == 1)
			cout << ans1 << " " << ans2 << endl;
		else
			cout << max << " " << max << endl;
	}
	return 0;
}
