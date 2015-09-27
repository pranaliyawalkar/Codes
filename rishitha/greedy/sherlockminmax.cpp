#include "iostream"
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char const *argv[])
{
	int n, p1 = -1, p2 = -1, maxi = -1, index = -1;
	cin >> n;
	std::vector<long long> v;
	long long a[101];
	for(int i = 0; i < n; i++){
		long long t;
		cin >> t;
		v.push_back(t);
	}
	sort(v.begin(), v.end());
	for(int i = 1; i < n; i++)
		a[i] = (v.at(i)+v.at(i-1))/2;
	long long p, q;
	cin >> p >> q;
	for(int i = 0; i < v.size(); i++){
		if(p <= v.at(i) && p1 == -1)
			p1 = i+1;
		if(q <= v.at(i)){
			p2 = i+1;
			break;
		}
	}
	if(p1 == -1 && p2 == -1)
		cout << q << endl;
	else if(p1 == 1 && p2 == 1)
		cout << p << endl;
	else{
		if(p1 == p2){
			if(a[p1-1] >= p || a[p1-1] <= q)
				index = a[p1-1];
			else if(a[p1-1] < p)
				index = p;
			else
				index = q;
		}
		else{
			if(p2 == -1)
				p2 = n+1;
			for(int i = p1; i <= p2; i++){
				if(i == 1 && maxi < (v.at(0)-p)){
					maxi = v.at(0)-p;
					index = p;
					continue;
				}
				else if(i == 1)
					continue;
				
				if(i == n+1 && maxi < (q-v.at(n-1))){
					maxi = q-v.at(n-1);
					index = q;
					continue;
				}
				else if(i == n+1)
					continue;
				
				if(i == p1){
					if(p <= a[i-1] && maxi < (a[i-1]-v.at(i-2))){
						maxi = a[i-1]-v.at(i-2);
						index = a[i-1];
					}
					else if(p > a[i-1] && maxi < (v.at(i-1)-p)){
						maxi = v.at(i-1)-p;
						index = p;
					}
				}
				else if(i == p2){
					if(q >= a[i-1] && maxi < (a[i-1]-v.at(i-2)))
						index = a[i-1];
					else if(q < a[i-1] && maxi < (q-v.at(i-2)))
						index = q;
				}
				else if(maxi < (a[i-1]-v.at(i-2))){
					maxi = a[i-1]-v.at(i-2);
					index = a[i-1];
				}
			}
		}
	}
	cout << index << endl;
	return 0;
}