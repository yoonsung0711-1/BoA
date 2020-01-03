sArr = ["aabbaccc",
    "ababcdcdababcdcd",
    "abcabcdede",
    "abcabcabcabcdededededede",
    "xababcdcdababcdcd"]

# s = sArr[0]
# unit = int(len(s)/2)
# unit
# prev = s[0:unit]
# prev
# curr = s[unit : unit + unit]
# prev == curr

# s = sArr[4]
# unit = int(len(s)/2)
# unit
# prev = s[0:unit]
# prev
# curr = s[unit : unit + unit]
# prev == curr
# prev = s[1:unit + 1]
# prev
# curr = s[unit + 1: unit + unit + 1]
# curr
# prev == curr

[i for i in range(0, 7, 3)]

s = sArr[4]
unit = int(len(s)/2)
unit

len(s) - 2 * unit
[i for i in range(0, len(s) - 2 * unit + 1, 1) ]

for i in range(0, len(s) - 2 * unit + 1, 1) :
    prev = s[0 + i : unit + i]
    curr = s[unit + i : unit * 2 + i]
    unit if prev == curr else None

s = sArr[3]
s
half = int(len(s)/2)
half

for i in range(half, 0, -1):
    unit = i
    cnt = 0
    for j in range(0, len(s) - unit * 2 + 1, unit) :
        start = j
        for k in range(0, len(s) % unit + 1, 1):
            shift = k
            prev = s[start + shift: start + shift + unit]
            prev1 = (start + shift, start + shift + unit)
            curr = s[start + shift + unit: start + shift + unit * 2 ]
            curr1 = (start + shift + unit, start + shift + unit * 2)
            'prev, curr = ({}, {})'.format(prev1, curr1)
            'prev, curr = ({}, {})'.format(prev, curr)
            cnt = cnt + 1 if prev == curr else 0
            '{}, {}'.format(curr, cnt + 1) if cnt != 0 else None



[i for i in range(half, 0, -1)]
len(s)
unit = 10
[j for j in range(0, len(s) % unit, 1)]
shift = 4
[(k, k + unit) for k in range(0 + shift, len(s) - unit + 1, unit)]



[(r, r + 2) for r in range(0, len("abcabcabcabc12dczczczcz"), 2)][0]
r = [7, 9, 8, 14, 7]

s[0]
s[1]
s[2]
s[3]
s[4]

# [관찰된 사실]
# aabbccdd => 2a2b2c2d : 연속된 2개의 문자열은 압축 효과 없음
# aaabbcc => 3a2b2c : 적어도 3개 이상의 문자열이 연속되어야 압축 효과 있음
# aaabbbaaabbb => 3a3b3a3b (x) / 2aaabbb (o) : 연속된 문자열의 길이가 길수록 압축 효과가 큼

# [순회방법]


# int는 소수점 자리수를 버림


word = s[0]
len(word)

if len(word) % 2 == 0:
    half = int(len(word)/ 2)

half

word = word[0:half]
word
