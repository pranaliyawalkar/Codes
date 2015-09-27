#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	for(int iter = 0; iter < t; iter++){
		int m, n;
		long long temp, ans = 0;
		cin >> m >> n;
		std::vector<long long> v1, v2;
		for(int i = 0; i < m-1; i++){
			cin >> temp;
			v1.push_back(temp);
		}
		for(int i = 0; i < n-1; i++){
			cin >> temp;
			v2.push_back(temp);
		}
		sort(v1.begin(), v1.end());
		sort(v2.begin(), v2.end());
		int i = m-2, j = n-2;
		int cutsc = 0, cutsr = 0;
		while(cutsr < n-1 && cutsc < m-1){
			if(v1.at(i) < v2.at(j)){
				cutsr++;
				ans = (ans+(v2.at(j)*(cutsc+1)))%1000000007;
				j--;
			}
			else{
				cutsc++;
				ans = (ans+(v1.at(i)*(cutsr+1)))%1000000007;
				i--;
			}
		}
		if(cutsc == m-1){
			for(int k = j; k >= 0; k--)
				ans = (ans+(v2.at(k)*(cutsc+1)))%1000000007;
		}
		else if(cutsr == n-1){
			for(int k = i; k >= 0; k--)
				ans = (ans+(v1.at(k)*(cutsr+1)))%1000000007;
		}
		cout << ans << endl;
	}
	return 0;
}