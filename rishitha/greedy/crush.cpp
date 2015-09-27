#include "iostream"
using namespace std;

long long arr[10000004];

int main(int argc, char const *argv[])
{
	long long n, a, b, k;
	int m;
	cin >> n >> m;
	for(int i = 0; i < m; i++){
		cin >> a >> b >> k;
		arr[a-1] += k;
		arr[b] -= k;
	}
	long long sum = 0, maxi = -1;
	for(int i = 0; i < n; i++){
		sum += arr[i];
		if(maxi < sum)
			maxi = sum;
	}
	cout << maxi << endl;
	return 0;
}