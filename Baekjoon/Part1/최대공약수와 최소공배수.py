n1, n2 = map(int, input().split())

divs = [i for i in range(1, min(n1, n2)+1) if n1 % i == 0 and n2 % i == 0]
gcd = max(divs)
print(gcd)

lcm = (n1*n2)//gcd
print(lcm)