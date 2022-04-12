def is_prime(num):
    if num == 1:
        return False
    else:
        for i in range(2, num):
            if num % i == 0:
                return False
    return True


N = int(input())
nums = list(map(int, input().split()))
primes = sum(map(is_prime, nums))
print(primes)
