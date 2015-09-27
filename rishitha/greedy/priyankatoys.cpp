#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	int n, temp;
	cin >> n;
	std::vector<int> v;
	for(int i = 0; i < n; i++){
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());
	int i = 0, ans = 0;
	while(i < n){
		int w = v.at(i);
		ans++;
		i++;
		while(i < n){
			if(v.at(i) <= w+4)
				i++;
			else
				break;
		}
	}
	cout << ans << endl;
	return 0;
}