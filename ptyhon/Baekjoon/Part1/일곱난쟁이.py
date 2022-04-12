num = 0
dwarfs = []
for _ in range(9):
    dwarfs.append(int(input()))

inter = sum(dwarfs) - 100

for i in range(9):
    suspect = inter - dwarfs[i]
    if suspect in dwarfs[:i]+dwarfs[i+1:]:
        dwarfs.remove(suspect)
        dwarfs.remove(dwarfs[i])
        break

print(*sorted(dwarfs), sep='\n')
