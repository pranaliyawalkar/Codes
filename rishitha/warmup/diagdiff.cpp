#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, starti, startj, sum1, sum2;
    cin >> n;
    starti = sum1 = sum2 = 0;
    startj = n-1;
    for(int i = 0; i < n; i++){
    	for(int j = 0; j < n; j++){
    		int temp;
    		cin >> temp;
    		if(i == j)
    			sum1 += temp;
    		if(i == starti && j == startj){
    			sum2 += temp;
    			starti++;
    			startj--;
    		}
    	}
    }
    int ans = sum1 - sum2;
    if(ans > 0){
    	cout << ans << endl;
    }
    else
    	cout << (-1*ans) << endl;
    return 0;
}

