import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
            arr[b][a] = true;
        }
        int min = Integer.MAX_VALUE;
        int minPerson = 0;
        for (int user = 1; user <= N; user++) {
            int result = bfs(user);
            if (min > result) {
                min = result;
                minPerson = user;
            }
        }
        System.out.println(minPerson);
    }

    public static int bfs(int start) {
        int kb = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        int[] visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = -1;
        }
        visited[start] = 0;
        while (!queue.isEmpty()) {
            int person = queue.poll();
            for (int friend = 1; friend <= N; friend++) {
                if (arr[person][friend] && visited[friend] == -1) {
                    queue.offer(friend);
                    visited[friend] = visited[person] + 1;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            kb += visited[i];
        }
        return kb;
    }
}