def get124_tail(num):
    l = []
    e = {1:1, 2:2, 0:4}
    def get_digit(l, num):
        if num == 0:
            return l
        r = num % 3
        q = int(num / 3)
        if r == 0:
            q = q - 1
        l = get_digit(l, q)
        l.append(e[r])
        return l
    return get_digit(l, num)


def get124_head(num):
    l = []
    e = {1:1, 2:2, 0:4}
    def get_digit(l, num):
        if num == 0:
            return l
        q = int(num / 3)
        r = num - 3 * q
        if r == 0:
            q = q - 1
        l.insert(0, e[r])
        return get_digit(l, q)
    return get_digit(l, num) 

for i in range(1, 41):
    print([x for x in get124_tail(i)])

for i in range(1, 41):
    print([x for x in get124_head(i)])





# def get124(num):
#     l = []
#     code = [4,1,2]
#     a = 0
#     while(num > 0):
#         a = num % 3
#         num = int(num / 3)
#         if a == 0:
#             num = num - 1
#         l.insert(0, code[a])
#     return l


# print(get124(13))
