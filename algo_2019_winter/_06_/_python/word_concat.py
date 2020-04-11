wordsets = [["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"],
         ["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"],
         ["hello", "one", "even", "never", "now", "world", "draw"]]

nums = [3, 5, 2]

def solution(n, words):
    def go(n, words):
        l = [list() for i in range(n)]
        prev = ''
        for (idx, word) in enumerate(words):
            i = idx % n
            l[i].append(word)
            if idx == 0:
                prev = word
                continue
            if word in words[:idx-1]:
            	return [i + 1, len(l[i])]
            if word[0] != prev[len(prev)-1]:
                return [i + 1, len(l[i])]
            prev = word
    answer = go(n, words)
    return answer if answer is not None else [0, 0]






