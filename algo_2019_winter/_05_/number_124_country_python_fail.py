def solution(num):
    l = []
    conv = {0: 4, 1: 1, 2: 2} 
    def recur(num, l):
        if num == 0:
            return l
        c = 0
        while True:
            if num > pow(3, c + 1):
                c = c + 1
            else:
                break

        dvnd = pow(3, c)
        q = int(num / dvnd)
        if dvnd == 1 or num % dvnd != 0 : 
            n = num - q * dvnd
            if q == 3:
                l.append(0)
            else:
                l.append(q)
        else :
            q = q - 1
            n = num - q * dvnd
            if q == 0:
                n = num - (q + 1) * dvnd
            l.append(q)
        l = recur(n, l)
        return l
    return "".join(str(conv[x]) for x in recur(num, l))