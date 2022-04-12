def is_prime(num):
    a = [True for _ in range(num+1)]
    for i in range(2, int(num**0.5)+1):
        if a[i]:
            for j in range(2*i, num+1, i):
                a[j] = False
    lst = [i for i in range(2, num+1) if a[i]]
    return lst


m = int(input())
n = int(input())

primes = [i for i in is_prime(n) if i >= m]

if not primes:
    primes.append(-1)
else:
    print(sum(primes))
print(primes[0])
