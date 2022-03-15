numPeople = 0
max = 0


def is_max(num):
    global max
    if num > max:
        max = num
    print(max)


for i in range(10):
    out, inn = map(int, input().split())
    numPeople -= out
    is_max(numPeople)
    numPeople += inn
    is_max(numPeople)

print(max)