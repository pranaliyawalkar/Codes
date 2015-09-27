#include "iostream"
using namespace std;

int main(int argc, char const *argv[])
{
	string a, b;
	int count = 0, ca = 0, cb = 0;
	cin >> a >> b;
	if(a.size() != b.size())
		cout << "-1" << endl;
	else{
		for(int i = 0; i < a.size(); i++){
			if(a.at(i) == '1')
				ca++;
			if(b.at(i) == '1')
				cb++;
			if(a.at(i) != b.at(i))
				count++;
		}
		if(ca != cb)
			cout << "-1" << endl;
		else
			cout << (count/2) << endl;
	}
	return 0;
}