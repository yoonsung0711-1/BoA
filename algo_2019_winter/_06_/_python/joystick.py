name = "JEROEN"
name = "AAAAAA"
print(name)

[ord(i) - ord('A') for i in map(lambda x: x, name)]
[ord('Z') + 1 - ord(i) for i in map(lambda x: x, name)]


[(ord(i) - ord('A'), ord('Z') + 1 - ord(i), 1 if i != 'A' else 0) for i in map(lambda x: x, "JEROEN")]

