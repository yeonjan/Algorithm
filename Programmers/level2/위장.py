from collections import Counter
def solution(clothes):
    answer=1
    kinds=Counter([kind for name, kind in clothes])
    for value in kinds.values():
        answer*=(value+1)
        
    return answer-1