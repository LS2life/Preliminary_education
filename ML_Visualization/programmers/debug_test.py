def solution(i):
	answer=0
	for i in range(0,i+1):
		if i%2==1:
			continue
		answer += i
	return answer