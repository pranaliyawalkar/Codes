#include "iostream"
#include "iomanip"
using namespace std;

int main (int argc, char const* argv[])
{
	int n, pos, neg, zeros;
	cin >> n;
	pos = neg = zeros = 0;
	for(int i = 0; i < n; i++){
		int temp;
		cin >> temp;
		if(temp > 0)
			pos++;
		else if(temp == 0)
			zeros++;
		else
			neg++;
	}
	double ans1 = (double)1.0*pos/n;
	double ans2 = (double)1.0*neg/n;
	double ans3 = (double)1.0*zeros/n;
	cout << setprecision(3) << fixed << ans1 << endl;
	cout << setprecision(3) << fixed << ans2 << endl;
	cout << setprecision(3) << fixed << ans3 << endl;
	return 0;
}
