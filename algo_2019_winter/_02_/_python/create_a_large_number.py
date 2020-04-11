_num = [1924, 1231234, 4177252841]
_k = [2, 3, 4]
_ret = [94, 3234, 775841]

num = _num[0]
k = _k[0]

split = list(map(lambda x: int(x), list(str(num)))); selected = []

digit = len(split) - k
digit
cursor = 0; begin = 0; end = begin + (k + 1); intvl = (begin, end)
prev = curr = max = None

'interval: [%d, %d]' % intvl

from functools import reduce
reduce(lambda x, y: x + str(y), split[begin:end], '')

while len(selected) < digit: 
    for j, s in enumerate(split[begin:end]):
        # print(j,s)
        curr = s
        if prev == -1:
            max = prev = curr
            cursor = begin + j
            print('*init: curr = %d' % curr)
        else:
            if curr > (max or -1):
                max = curr
                cursor = begin + j
                print('**curr = %d > %d' % (curr, max))
            elif curr <= max:
                print('curr(%d) <= %d' % (curr, max))
    selected.append(split[cursor])
    prev = curr = max = -1
    k = k + begin - cursor
    begin = cursor + 1
    end = begin + (k + 1)
    print(selected)


from functools import reduce
reduce(lambda x, y: x + str(y), selected, '')