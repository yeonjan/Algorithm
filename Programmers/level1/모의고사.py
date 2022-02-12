def solution(answers):
    score=[0,0,0]
    person=[[1, 2, 3, 4, 5],
            [ 2, 1, 2, 3, 2, 4, 2, 5],
            [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    
    for p in range(3):
        result=[1 for idx, val in enumerate(answers) if val==person[p][idx%len(person[p])]]
        score[p]=sum(result)
    
    m=max(score)
    answer=[idx+1 for idx, val in enumerate(score) if m==val ]
    return answer