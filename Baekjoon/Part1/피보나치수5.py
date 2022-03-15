"""
n = int(input())

fib = [0, 1, ]

for idx in range(2, n+1):
    fib.append(fib[idx - 1] + fib[idx - 2])

print(fib[n])
"""


def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)


num = int(input())
print(fibonacci(num))
