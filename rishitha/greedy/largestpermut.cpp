#include "iostream"
using namespace std;

int main(int argc, char const *argv[])
{
	long long n, k, s, t = 0, i = 0;
	cin >> n >> k;
	s = n;
	int a[100001];
	long long end = min(n, k);
	for(int j = 0; j < n; j++)
		cin >> a[j];
	while(t < end && i < n){
		if(a[i] == s){
			i++;
			s--;
			continue;
		}
		for(int j = i; j < n; j++){
			if(a[j] == s){
				a[j] = a[i];
				a[i] = s;
				s--;
				i++;
				t++;
				break;
			}
		}
	}
	for(i = 0; i < n; i++)
		cout << a[i] << " ";
	cout << endl;
	return 0;
}