#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	/* code */
	int n, k, mul = 0, temp;
	long long ans = 0;
	std::vector<int> v;
	cin >> n >> k;
	for(int i = 0; i < n; i++){
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());
	for(int i = 0; i < n; i++){
		if(i%k == 0)
			mul++;
		ans += (mul*v.at(n-i-1));
	}
	cout << ans << endl;
	return 0;
}