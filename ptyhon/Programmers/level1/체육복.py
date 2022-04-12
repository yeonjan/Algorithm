def solution(n, lost, reserve):
    res=list(r for r in reserve if r not in lost)
    los=list(l for l in lost if l not in reserve) 
    los.sort()
    res.sort()
    
    for p in res[:]:
        f = p-1
        b = p+1
        if f in los:
            los.remove(f)
        elif b in los:
            los.remove(b)
    return n-len(los)