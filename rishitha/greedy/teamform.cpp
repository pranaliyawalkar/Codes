#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	/* code */
	int t;
	cin >> t;
	for (int i = 0; i < t; ++i)
	{
		int n;
		cin >> n;
		if(n == 0){
			cout << "0" << endl;
			continue;
		}
		long long ans = 9999999999, temp;
		std::vector<long long> v;
		for(int j = 0; j < n; j++){
			cin >> temp;
			v.push_back(temp);
		}
		long long len = 1;
		sort(v.begin(), v.end());
		for(int j = 0; j < n-1; j++){
			if(v.at(j)+1 == v.at(j+1)){
				len++;
			}
			else{
				if(len < ans)
					ans = len;
				len = 1;
			}
		}
		if(len < ans)
			ans = len;
		cout << ans << endl;
	}
	return 0;
}