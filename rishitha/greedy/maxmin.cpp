#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	/* code */
	int n, k, index;
	long long mini = 9999999999, temp;
	cin >> n >> k;
	std::vector<long long> v;
	for(int i = 0; i < n; i++){
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());
	for(int i = 0; i <= n-k; i++){
		if(v.at(i+k-1)-v.at(i) < mini)
			mini = v.at(i+k-1)-v.at(i);
	}
	cout << mini << endl;
	return 0;
}