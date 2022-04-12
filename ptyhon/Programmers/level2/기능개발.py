import math
def solution(progresses, speeds):
    answer = []
    days=list(math.ceil((100-p)/s) for p,s in zip(progresses,speeds))

    
    count=1
    dist_day= days.pop(-1)
    while days:    
        if dist_day>=days[-1]:
            days.pop(-1)
            count+=1
        else:
            answer.append(count)
            count=1
            dist_day= days.pop(-1)
    answer.append(count)
    return answer