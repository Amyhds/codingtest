import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, I;
    static int[][] visited;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(bf.readLine());
            visited = new int[I][I];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            solution(new int[]{startX, startY}, new int[]{targetX, targetY});
            System.out.println(visited[targetX][targetY] - 1);
        }
    }

    public static void solution(int[] start, int[] target) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start[0]][start[1]] = 1;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            for (int d = 0; d < 8; d++) {
                int nextX = currX + dir[d][0];
                int nextY = currY + dir[d][1];
                if (nextX < 0 || nextX >= I || nextY < 0 || nextY >= I) {
                    continue;
                }
                if (visited[nextX][nextY] > 0) {
                    continue;
                }
                queue.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = visited[currX][currY] + 1;
            }
        }
    }
}