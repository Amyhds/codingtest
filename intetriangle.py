def solution(triangle):
    for i in range(1, len(triangle)): #1~4
        for j in range(i+1): #2~5
            if j==0:
                triangle[i][j] += triangle[i-1][j]
            elif j==i:
                triangle[i][j] += triangle[i-1][j-1]
            else:
                triangle[i][j] += max(triangle[i-1][j], triangle[i-1][j-1])
    return max(triangle[-1])