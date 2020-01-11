import itertools
def traverse(arr):
    alist = list(itertools.chain(*arr))
    alist.sort()
    t = arr

    encode = {}
    decode = {}
    num = 0
    for airport in alist:
        if encode.get(airport, None) is None:
            encode[airport] = num
            decode[num] = airport
            num = num + 1

    d = len(encode.keys())
    mat = [[0 for i in range(d)] for j in range(d)]

    for i in range(len(t)):
        mat[encode.get(t[i][0])][encode.get(t[i][1])] = 1

    h = []
    i = encode['ICN']

    def dig(i):
        for j in range(len(mat[i])):
            if mat[i][j] == 1:
                mat[i][j] = mat[i][j] - 1
                dig(j)
        h.append(i)

    dig(i)
    h.reverse()
    return [decode[x] for x in h]


def solution(tickets):
    return traverse(tickets)


# import unittest
# class TestEuler(unittest.TestCase):
#     def test_travel_route(self):
#         self.assertEqual(rArr[0], traverse(tArr[0]))
#         self.assertEqual(rArr[1], traverse(tArr[1]))

# if __name__ == '__main__':
#     unittest.main()

#---------------------------------------------------
# def move(i):
#     for j in range(len(mat[i])):
#         if mat[i][j] == 1:
#             mat[i][j] = 0
#             return j

# i = encode['ICN']
# h.append(i)

# for n in range(len(t)):
#     i = move(i)
#     h.append(i)

# [decode[x] for x in h]

#---------------------------------------------------
# mat[i]
# j = [j for j, v in enumerate(mat[i]) if v != 0][0]
# (i,j)
# mat[i][j] = 0
# mat[j]

# i = j
# j = [j for j, v in enumerate(mat[i]) if v != 0][0]
# (i,j)
# mat[i][j] = 0
# mat[j]

# i = j
# j = [j for j, v in enumerate(mat[i]) if v != 0][0]
# (i,j)
# mat[i][j] = 0
# mat[j]

# tArr = [
#     [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]],
#     [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]],
#     [["ICN", "SFO"], ["SFO", "ICN"], ["ICN", "ATL"]]
# ]

# rArr = [
#     ["ICN", "JFK", "HND", "IAD"],
#     ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"],
#     ["ICN", "SFO", "ICN", "ATL"]
# ]