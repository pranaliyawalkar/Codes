#include "iostream"
using namespace std;

int main(int argc, char const *argv[])
{
	int h[100002], n, maxi = -1;
	cin >> n;
	h[0] = 0;
	for(int i = 1; i <= n; i++){
		cin >> h[i];
		if(maxi < h[i])
			maxi = h[i];
	}
	int lo = 0, hi = maxi+1;
	while(lo < hi){
		int mid = (lo+hi)/2, flag = 0;
		long long botenergy = mid;
		for(int i = 1; i <= n; i++){
			if(h[i] > botenergy){
				botenergy -= (h[i]-botenergy);
				if(botenergy < 0){
					flag = 1;
					break;
				}
			}
			else{
				botenergy += (botenergy-h[i])%(maxi+1);
			}
		}
		if(flag == 1)
			lo = mid+1;
		else
			hi = mid;
	}
	cout << lo << endl;
	return 0;
}