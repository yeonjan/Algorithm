from functools import cmp_to_key

def cmp(x,y):
            if(x+y>y+x):
                return -1
            else:
                return 1
            
def solution(numbers):
    answer = ''
    if(sum(numbers)==0):
        answer="0"
    else:
        #string 리스트로 변환
        #snumbers = list(map(str, list_string))
        numbers=[str(x) for x in numbers]
        #정렬
        numbers.sort(key=cmp_to_key(cmp)) 
        answer=("".join(numbers))
    return answer