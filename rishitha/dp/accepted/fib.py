numbers = map(int, raw_input().split())
dp = []
dp.append(0)
dp.append(numbers[0])
dp.append(numbers[1])
n = numbers[2]
for i in range(3,n+1):
	dp.append(dp[i-1]*dp[i-1]+dp[i-2])
print (dp[n])
