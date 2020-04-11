h = [[6,9,5,7,4],[3,9,9,3,5,7,2],[1,5,3,6,7,6,5]]
r = [[0,0,2,2,4],[0,0,0,3,3,3,6],[0,0,2,0,0,5,6]]

heights = h[0]

receivers = []
for i in range(0, len(heights), 1):
    if i == 0:
        receivers.append(0)
        continue

    for j in range(i - 1, -1, -1):
        if heights[j] > heights[i]:
            receivers.append(j + 1)
            break
        else: 
            if j == 0:
                receivers.append(0)
'return {}'.format(receivers)

