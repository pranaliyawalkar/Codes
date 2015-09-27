#include "iostream"
#include <algorithm>
#include <vector>
#include <utility>
using namespace std;

int main(int argc, char const *argv[])
{
	int n;
	cin >> n;
	std::vector<pair<long long, int> > v;
	for(int iter = 0; iter < n; iter ++){
		long long temp, t, d;
		cin >> t >> d;
		temp = t+d;
		v.push_back(pair<long long, int>(temp, iter+1));
	}
	std::sort(v.begin(), v.end());
	for( vector<pair<long long, int> >::iterator it = v.begin(); it != v.end(); ++it )
		cout << it->second << " ";
	cout << endl;
	return 0;
}