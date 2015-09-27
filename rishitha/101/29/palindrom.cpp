#include "iostream"
using namespace std;

long long gcd(long long a, long long b){
	return b == 0 ? a : gcd(b, a%b);
}

int main(int argc, char const *argv[])
{
	int t;
	cin >> t;
	for(int iter = 1; iter <= t; iter++){
		string s;
		cin >> s;
		long long count = 0, tot = 0;
		for(int i = 0; i < s.size(); i++){
			int c[27] = {0};
			int oddc = 0;
			for(int j = i; j < s.size(); j++){
				c[s.at(j)-'a']++;
				if(c[s.at(j)-'a']%2 == 1)
					oddc++;
				else
					oddc--;
				if(oddc == 0 && (j-i+1)%2 == 0)
					count++;
				else if(oddc == 1 && (j-i+1)%2 == 1)
					count++;
				tot++;
			}
		}
		long long g = gcd(count, tot);
		cout << (count/g) << "/" << (tot/g) << endl;
	}
	return 0;
}