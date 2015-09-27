#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	int n, k;
	string s;
	cin >> n >> s >> k;
	k = k%26;
	for(int i = 0; i < n; i++){
		char a = s.at(i);
		if(a >= 'a' && a <= 'z'){
			int b = s.at(i)-'a';
			b = (b+k)%26;
			char c = 'a'+b;
			cout << c;
		}
		else if(a >= 'A' && a <= 'Z'){
			int b = s.at(i)-'A';
			b = (b+k)%26;
			char c = 'A'+b;
			cout << c;
		}
		else
			cout << s.at(i);
	}
	cout << endl;
	return 0;
}
