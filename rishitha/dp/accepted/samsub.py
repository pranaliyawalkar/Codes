string = raw_input()
n = len(string)
sumc = 0
sum_prev = 0
ans = 0
for i in range(1, n+1):
	num = (ord(string[i-1])-ord('0'))
	sumc = sum_prev*10+(i*num)
	ans = (ans+sumc)%1000000007
	sum_prev = sumc%1000000007
print ans
