import time

start = time.time()

N = int(input())
nums = list(map(int, input().split()))
print(min(nums), max(nums))

print("time :", time.time() - start)
