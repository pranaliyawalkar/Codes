#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	int n, i;
	long long k, temp, ans = 0;
	std::vector<long long> v;
	cin >> n >> k;
	for(int i = 0; i < n; i++){
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());
	for(i = 0; i < n; i++){
		if(ans+v.at(i) < k)
			ans += v.at(i);
		else
			break;
	}
	cout << i << endl;
	return 0;
}