sArr = ["aabbaccc",
    "ababcdcdababcdcd",
    "abcabcdede",
    "abcabcabcabcdededededede",
    "xababcdcdababcdcd"]
res = [7, 9, 8, 14, 17]


def comp(s):
    minlen = len(s)
    whole_str = []
    for unit in range(int(len(s)/2), 0, -1):
        q = int(len(s)/unit)
        prev = s[:unit]
        cnt = 0
        remn = s[unit * q:]
        for i in range(1, q + 1):
            curr = s[unit*i:unit*(i+1)]
            if curr == prev:
                cnt = cnt + 1
            elif curr != prev:
                if cnt > 0:
                    whole_str.append(str(cnt + 1) + prev)
                else:
                    whole_str.append(prev)
                prev = curr
                cnt = 0
        remn and whole_str.append(remn)
        # print("".join(whole_str))
        curlen = len("".join(whole_str))
        if curlen < minlen:
            minlen = curlen
            # print(minlen)
        whole_str = []
    return minlen

comp(sArr[0])
# import unittest
# class Test(unittest.TestCase):
#     def test_string_compression(self):
#         for i in range(0, 5):
#             self.assertEqual(comp(sArr[i]), res[i])

# if __name__ == '__main__':
#     unittest.main()
