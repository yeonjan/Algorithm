def easy(num):
    sum = 0
    state = 1
    end = 0
    for _ in range(num):
        sum += state
        end += 1
        if end == state:
            end = 0
            state += 1
    return sum


a, b = map(int, input().split())
print(easy(b) - easy(a-1))
