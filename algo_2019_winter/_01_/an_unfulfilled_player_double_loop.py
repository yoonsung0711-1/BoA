participants = [["leo", "kiki", "eden"],
                ['marina', 'josipa', 'nikola', 'vinko', 'filipa'],
                ['mislav', 'stanko', 'mislav', 'ana']]
completions = [['eden', 'kiki'],
                ['josipa', 'filipa', 'marina', 'nikola'],
                ['stanko', 'ana', 'mislav']]

part = participants[2]
comp = completions[2]

part
comp

for p in range(len(part) - 1, -1, -1):
    '============='
    p, part[p]
    match = False
    r = []
    i = len(comp) - 1
    '_____________'
    while i > -1:
        i, comp[i]
        if part[p] == comp[i]:
            'match'
            match = True
        else: 
            'unmatch'
            r.append(comp[i])
        i = i - 1
    if not match :
        'return {}'.format(part[p])
    comp = r

