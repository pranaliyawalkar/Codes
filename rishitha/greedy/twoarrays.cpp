#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	for(int iter = 0; iter < t; iter++){
		int n, flag = 0;
		long long k;
		std::vector<long long> v1, v2;
		cin >> n >> k;
		for(int i = 0; i < n; i++){
			long long temp;
			cin >> temp;
			v1.push_back(temp);
		}
		for(int i = 0; i < n; i++){
			long long temp;
			cin >> temp;
			v2.push_back(temp);
		}
		sort(v1.begin(), v1.end());
		sort(v2.begin(), v2.end());
		for(int i = 0; i < n; i++){
			long long sum = v1.at(i)+v2.at(n-1-i);
			if(sum < k){
				flag = 1;
				break;
			}
		}
		if(flag == 1)
			cout << "NO" << endl;
		else
			cout << "YES" << endl;
	}
	return 0;
}