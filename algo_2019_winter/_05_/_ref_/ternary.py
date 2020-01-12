
def get_ternary(num):
    dvnd = num; d = 0; s = 0
    while True:
        if dvnd >= 3:
            d = d + 1
            dvnd = int(dvnd / 3)
        else:
            break
    remnant = num - pow(3,d)
    if remnant != 0 :
        s = s + get_ternary(remnant)
    return s + pow(10, d)

def get_124(num):
    dvnd = num; d = 0; s = 0
    while True:
        if dvnd >= 3:
            d = d + 1
            dvnd = int(dvnd / 3)
        else:
            break
    remnant = num - pow(3,d)
    if remnant != 0 :
        s = s + get_ternary(remnant)
    return s + pow(10, d)


# def get_quarternary(num):
#     dvnd = num; d = 0; s = 0
#     while True:
#         if dvnd >= 4:
#             d = d + 1
#             dvnd = int(dvnd / 4)
#         else:
#             break
#     remnant = num - pow(4,d)
#     if remnant != 0 :
#         s = s + get_quarternary(remnant)
#     return s + pow(10, d)

# cvs = {'1': '1', '2': '2', '0': '4'}