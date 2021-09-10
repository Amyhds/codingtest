global answer

def dfs(begin, target, words, visit):
    answer = 0
    stacks = [begin]
    while stacks:
        stack = stacks.pop()
        if stack == target:
            return answer

        for i in range(len(words)): # 0~5
            if len([j for j in range(len(words[i])) if words[i][j] != stack[j]]) == 1:
                 # 0~2
                 # 단어의 세 글자 중 스택의 단어의 j번째 글자와 다른 글자의 개수가 1개라면
                if visit[i] != 0:
                    continue
                visit[i] = 1
                stacks.append(words[i]) # 한글자 다른 단어를 스택에 추가
        answer += 1
    return answer

def solution(begin, target, words):
    if target not in words:
        return 0
    visit = [0 for i in words]
    answer = dfs(begin, target, words, visit)
    return answer