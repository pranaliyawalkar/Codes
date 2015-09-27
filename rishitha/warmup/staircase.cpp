#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int n;
	cin >> n;
	for(int i = 1; i <= n; i++){
		for(int j = n-i; j > 0; j--)
			cout << " ";
		for(int j = n-i+1; j <= n; j++)
			cout << "#";
		cout << endl;
	}
	return 0;
}
