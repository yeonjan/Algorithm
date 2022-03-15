import time

start = time.time()


def qsort(nums):
    if len(nums) <= 1:
        return nums

    if len(nums) > 1:
        pivot = nums[0]
        down = [n for n in nums if pivot > n]
        up = [n for n in nums if pivot < n]

        return qsort(down) + [pivot] + qsort(up)


N = int(input())
nums = list(map(int, input().split()))
sorted_nums = qsort(nums)
print(sorted_nums[0], sorted_nums[N - 1])

print("time :", time.time() - start)
