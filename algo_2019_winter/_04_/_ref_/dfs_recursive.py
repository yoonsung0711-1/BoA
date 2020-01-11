
adj = []
euler = []

def findEulerianCircuit(here):
    for there in range(1, len(adj)):
        while adj[here][there] > 0:
            adj[here][there] = adj[here][there] - 1
            adj[there][here] = adj[there][here] - 1
            findEulerianCircuit(there)
    euler.append(here)

adj = [[0 for i in range(8)] for j in range(8)]
adj[1][2] = adj[2][1] = 1
adj[2][5] = adj[5][2] = 1
adj[4][5] = adj[5][4] = 1
adj[3][4] = adj[4][3] = 1
adj[3][1] = adj[1][3] = 1
adj[5][7] = adj[7][5] = 1
adj[6][7] = adj[7][6] = 1
adj[5][6] = adj[6][5] = 1

findEulerianCircuit(1)

euler.reverse()

# print(*euler)
print(" -> ".join(map(str, euler)))

