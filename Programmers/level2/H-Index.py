def solution(citations):
    h = 0
    n=len(citations)
    citations.sort()
    for i in range(n):
        if(citations[i]>=n-i):
            h=n-i
            break
    return h