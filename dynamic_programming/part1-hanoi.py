def sum(n):
    if n == 1:
        return 1
    else:
        return n + sum(n-1)

sum(5)

def sum(n):
    if n < 0:
        return -1
    if n == 1:
        return 1
    return n + sum(n-1)

sum(-1)
sum(5)

def power(x, n):
    if (n == 0):
        return 1
    elif (x == 1):
        return x
    else:
        return x * power(x, n - 1)

power(10,2)

def hanoi(start, end, way, n):
    if n <= 0:
        return
    hanoi(start, way, end, n - 1)
    print("{}번 원반을 {}에서 {}로 옮깁니다".format(n, start, end))
    hanoi(way, end, start, n - 1)

hanoi('start', 'end', 'way', 3)

start = [3,2,1]
end = []
way = []

one = start.pop()
end.append(one)
start
end
way

one = start.pop()
way.append(one)
two = start.pop()
end.append(two)
one = way.pop()
end.append(one)

one = start.pop()
end.append(one)
two = start.pop()
way.append(two)
one = end.pop()
way.append(one)
three = start.pop()
end.append(three)
one = way.pop()
start.append(one)
two = way.pop()
end.append(two)
one = start.pop()
end.append(one)

#

one = start.pop(); end.append(one) #1
start
end
way

one = start.pop(); way.append(one) #1
two = start.pop(); end.append(two) ##2
one = way.pop(); end.append(one)   #1

one = start.pop(); end.append(one)     #1
two = start.pop(); way.append(two)     ##2
one = end.pop(); way.append(one)       #1
three = start.pop(); end.append(three) ##3
one = way.pop(); start.append(one)     #1
two = way.pop(); end.append(two)       ##2
one = start.pop(); end.append(one)     #1

def hanoi2(start, end, way, n):
    if (n <= 0):
        return
    hanoi2(start, way, end, n - 1)
    end.append(start.pop())
    hanoi2(way, end, start, n - 1)

start = [3,2,1]
end = []
way = []
hanoi2(start, end, way, 3)
start
end
way

