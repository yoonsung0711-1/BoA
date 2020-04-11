h = [[6,9,5,7,4],[3,9,9,3,5,7,2],[1,5,3,6,7,6,5]]
r = [[0,0,2,2,4],[0,0,0,3,3,3,6],[0,0,2,0,0,5,6]]

heights = h[0]

answer = [0] * len(heights)
answer

while heights:
    i = heights.pop()
    for j in range(len(heights)-1,-1,-1):
        if heights[j] > i:
            answer[len(heights)] = j +1
            break
print('return {}'.format(answer))


