cArr = [
    [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]],
    [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
]

from functools import reduce

def solution(clothes):
    category = {}
    nums = []

    for c in clothes:
        key = c[1]
        if category.get(key, None) is None:
            l = []; l.append(c[0])
            category[key] = l
        else:
            l = category.get(key)
            l.append(c[0])

    for k in category.keys():
        nums.append(len(category[k]))
    # sum = 1
    if len(nums) == 1:
        return len(nums)
    else:
        # for n in nums:
        #     sum = sum * (n + 1)
        # return sum - 1
        return reduce(lambda x,y: x * (y + 1), nums, 1) - 1

print(solution(cArr[0]))
