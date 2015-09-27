#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	for(int iter = 0; iter < t; iter++){
		int n, dp1[10001], dp2[10001], dp3[10001], dp4[10001], dp5[10001];
		std::vector<int> v;
		cin >> n;
		for(int j = 0; j < n; j++){
			int temp;
			cin >> temp;
			v.push_back(temp);
		}
		sort(v.begin(), v.end());
		int mini = v.at(0);
		dp1[0] = 0; dp2[0] = 0; dp3[0] = 0; dp4[0] = 0; dp5[0] = 0;
		dp1[1] = 0;
		for(int i = 1; i <= v.size(); i++){
			if(v.at(i-1) != mini){
				int d = v.at(i-1)-mini;
				dp1[i] = dp1[i-1] + d/5 + (d%5)/2 + (d%5)%2;
			}
			else
				dp1[i] = dp1[i-1];
		}
		mini--;
		for(int i = 1; i <= v.size(); i++){
			if(v.at(i-1) != mini){
				int d = v.at(i-1)-mini;
				dp2[i] = dp2[i-1] + d/5 + (d%5)/2 + (d%5)%2;
			}
			else
				dp2[i] = dp2[i-1];
		}
		mini--;
		for(int i = 1; i <= v.size(); i++){
			if(v.at(i-1) != mini){
				int d = v.at(i-1)-mini;
				dp3[i] = dp3[i-1] + d/5 + (d%5)/2 + (d%5)%2;
			}
			else
				dp3[i] = dp3[i-1];
		}
		mini--;
		for(int i = 1; i <= v.size(); i++){
			if(v.at(i-1) != mini){
				int d = v.at(i-1)-mini;
				dp4[i] = dp4[i-1] + d/5 + (d%5)/2 + (d%5)%2;
			}
			else
				dp4[i] = dp4[i-1];
		}
		mini--;
		for(int i = 1; i <= v.size(); i++){
			if(v.at(i-1) != mini){
				int d = v.at(i-1)-mini;
				dp5[i] = dp5[i-1] + d/5 + (d%5)/2 + (d%5)%2;
			}
			else
				dp5[i] = dp5[i-1];
		}
		cout << min(dp1[n], min(dp2[n], min(dp3[n], min(dp4[n], dp5[n])))) << endl;
	}
	return 0;
}