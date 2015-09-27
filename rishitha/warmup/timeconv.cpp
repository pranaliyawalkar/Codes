#include "iostream"
using namespace std;

int main (int argc, char const* argv[])
{
	string str;
	cin >> str;
	int h1 = str.at(0)-'0';
	int h2 = str.at(1)-'0';
	int hr = h1*10+h2;
	char ampm = str.at(8);
	if(ampm == 'A'){
		if(hr == 12)
			cout << "00" << str.substr(2,6) << endl;
		else
			cout << str.substr(0,8) << endl;
	}
	else{
		if(hr == 12)
			cout << str.substr(0,8) << endl;
		else
			cout << (12+hr) << str.substr(2,6) << endl;
	}
	return 0;
}
