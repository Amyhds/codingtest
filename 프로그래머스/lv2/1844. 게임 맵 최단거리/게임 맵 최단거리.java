import java.util.*;

class Solution {
    static int N, M;
    static int answer;
    static int[][] maps;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void bfs() {
        Queue<Pos> que = new ArrayDeque<>();
        que.offer(new Pos(0, 0));
        int lastX = 0;
        int lastY = 0;
        while(!que.isEmpty()) {
            Pos curr = que.poll();
            int x = curr.x;
            int y = curr.y;
            for(int d = 0; d < 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || maps[nx][ny] == 0) {
                    continue;
                }
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    lastX = nx;
                    lastY = ny;
                    if (nx == N - 1 && ny == M - 1) {
                        break;
                    }
                    que.offer(new Pos(nx, ny));
                }
            }
        }
        if (maps[N - 1][M - 1] <= 1) {
            answer = -1;
        } else {
            answer = maps[N - 1][M - 1];
        }
        
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        N = maps.length;
        M = maps[0].length;
        bfs();
        return answer;
    }
}