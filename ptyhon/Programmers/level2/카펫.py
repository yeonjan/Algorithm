def solution(brown, yellow):
    answer = []
    total = brown + yellow
    
    div=list( i for i in range(2,total) if (total%i==0))
    div.reverse()
    div= list([div[i],div[-(i+1)]] for i in range(-(-len(div)//2)) if div[-(i+1)]>2 )
    
    answer = list( d for d in div if (2*d[0] + 2*d[1] == brown+4))
    
    return answer[0]
