T = int(input())


def qsort(nums):
    if len(nums) <= 1:
        return nums
    else:
        pivot = nums[0]
        down = list(n for n in nums[1:] if n < pivot)
        up = list(n for n in nums[1:] if n >= pivot)

        return qsort(down) + [pivot] + qsort(up)


for i in range(T):
    arr = list(map(int, input().split()))
    print(qsort(arr)[7])
