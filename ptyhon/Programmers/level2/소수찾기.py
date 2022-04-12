from itertools import permutations
def is_prime(num):
    if num<2:
        return False
    for i in range(2,num):
        if num%i==0:
            return False
    return True

def solution(numbers):
    all_num = set()
    count=0
    for digit in range(len(numbers)):
        all_num|=set(map(int,map("".join,permutations(numbers,digit+1))))
    
    for num in all_num:
        if is_prime(num)==True:
            count+=1
    
    return count
