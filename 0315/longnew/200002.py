import sys

n = int(sys.stdin.readline())
data = []
dp = [[0] * (n + 1) for i in range(n + 1)]

for i in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    data.append(temp)

for x in range(n):
    for y in range(n):
        dp[x + 1][y + 1] = dp[x][y + 1] + dp[x + 1][y] - dp[x][y] + data[x][y]

ans = -1*float('INF')
for i in range(1, n + 1):
    for x in range(n - i + 1):
        for y in range(n - i + 1):
            nx = x + i
            ny = y + i
            ans = max(ans, dp[nx][ny] - dp[nx][y] - dp[x][ny] + dp[x][y])

print(ans)
