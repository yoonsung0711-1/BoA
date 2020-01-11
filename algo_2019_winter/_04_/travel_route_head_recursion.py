import itertools
import copy
from operator import itemgetter

def keymap(tickets):
    alist = list(itertools.chain(*tickets))
    alist.sort()
    encode = {}
    decode = {}
    num = 1
    for airport in alist:
        if encode.get(airport, None) is None:
            encode[airport] = num
            decode[num] = airport
            num = num + 1
    return (encode, decode)

# def toMatrix(tickets, encode):
#     mat = [[0 for i in range(len(encode))] for j in range(len(encode))]
#     for i in range(len(tickets)):
#         mat[encode.get(tickets[i][0]) - 1][encode.get(tickets[i][1]) - 1] = 1
#     return mat

def encoded_ordered_ticket(tickets, encode):
    e_tickets = []
    for ticket in tickets:
        e_ticket = []
        e_ticket.append(encode[ticket[0]])
        e_ticket.append(encode[ticket[1]])
        e_ticket.append(False)
        e_tickets.append(e_ticket)
    return sorted(e_tickets, key=itemgetter(0,1))


# 다음으로 방문할 노드가 이전 노드가 같으면 
# -> False 반환 (백트래킹시 발생 가능)

# 다음으로 방문 가능한 노드가 없으면 
# -> 방문 기록의 마지막 방문지를 제거하고
# -> 방문지로 가는 티켓의 사용여부 플래그를 되돌린 뒤(1) 종료

# 다음으로 방문 가능한 노드가 있을 경우 
# -> 방문 기록에 해당 방문지를 추가하고
# -> 티켓의 플래그를 방문(0)으로 변경
# -> 노드 이동
# -> 방문 가능한 노드가 없을 때까지 재귀호출 반복 => 티켓 소진 여부 확인

def move(tickets, memo, prev, i):
    if len(memo) == len(tickets) + 1: # 티켓 소진 여부 체크
        return True

    for ticket in tickets:
        if ticket[0] == i and ticket[2] == False: # 소진한 티켓은 제외
            j = ticket[1] # 다음 노드 찾기
            if j == prev: # 백트래킹시 바로 이전 노드로 다시 방문하지 않도록 방지
                return False
            prev = -1 
            memo.append(j) 
            ticket[2] = True 
            check = move(tickets, memo, prev, j)
            if check: # 티켓을 다 소진한 경우 memo 반환
                return memo
            else: # 티켓을 소진하지 못한채 False를 반환받는 경우
                ticket[2] = False
                j = memo.pop()
                prev = j
                move(tickets, memo, prev, i)
    return False

def solution(tickets):
    s_tickets = tickets
    encode, decode = keymap(s_tickets)
    tickets = encoded_ordered_ticket(s_tickets, encode)
    memo = []
    prev = -1
    i = encode['ICN']
    memo.append(i)
    return [decode[x] for x in move(tickets, memo, prev, i)]

# j = mat[i].index(1); j; decode[j]
# tsize = tsize - 1; tsize
# mat[i][j] = 0
# nh.append(i); nh
# sh.append(decode[i]); sh
# prev = i
# i = j

# 1 in mat[i]; mat[i]
# tsize != 0

# j = nh.pop(); j; sh.pop() 
# tsize = tsize + 1; tsize
# mat[i][j] = 1
# prev == j

# i = j

# def hop()


tArr = [
    [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]],
    [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]],
    [["ICN", "SFO"], ["SFO", "ICN"], ["ICN", "ATL"]],
    [["HND", "IAD"], ["IAD", "JFK"], ["IAD", "ICN"], ["ICN", "HND"], ["JFK", "SFO"], ["SFO", "IAD"]]
]

rArr = [
    ["ICN", "JFK", "HND", "IAD"],
    ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"],
    ["ICN", "SFO", "ICN", "ATL"],
]

print(solution(tArr[0]))
print(solution(tArr[1]))
print(solution(tArr[2]))
print(solution(tArr[3]))



