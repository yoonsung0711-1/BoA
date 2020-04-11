participants = [['leo', 'kiki', 'eden'],
                ['marina', 'josipa', 'nikola', 'vinko', 'filipa'],
                ['mislav', 'stanko', 'mislav', 'ana']]
completions = [['eden', 'kiki'],
                ['josipa', 'filipa', 'marina', 'nikola'],
                ['stanko', 'ana', 'mislav']]

part = participants[0]
comp = completions[0]

part
comp

cmap = {}
for c in comp:
    cfound = cmap.get(c, None)
    if cfound == None:
        cmap[c] = 1
    else :
        cmap[c] = cfound + 1

cmap

for p in part:
    pfound = cmap.get(p, None)
    if pfound != None and pfound > 0:
        cmap[p] = pfound -1
    else : 
        cmap[p] = pfound -1
        'return {}'.format(p)

cmap
