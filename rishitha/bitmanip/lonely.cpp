#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int n, temp, ans = 0;
	cin >> n;
	for(int i = 0; i < n; i++){
		cin >> temp;
		ans = ans ^ temp;
	}
	cout << ans << endl;
	return 0;
}
