def get_binary(n):
    binary = []
    while n > 0:
        q, r = divmod(n, 2)
        binary.append(r)
        n = q
    return [num[0] for num in enumerate(binary) if num[1] == 1]


t = int(input())
for _ in range(t):
    result = get_binary(int(input()))
    print(*result, sep=' ')
