import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        line = new int[100001];
        for (int i = 0; i <= 100000; i++) {
            line[i] = -1;
        }
        bfs();
        System.out.println(line[K]);
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        line[N] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int[] next = teleport(curr);
            for (int i = 0; i < 3; i++) {
                if (next[i] < 0 || next[i] >= 100001) {
                    continue;
                }
                if (line[next[i]] >= 0) {
                    continue;
                }
                if (next[i] == K) {
                    line[next[i]] = line[curr] + 1;
                    return;
                }
                line[next[i]] = line[curr] + 1;
                queue.offer(next[i]);
            }
        }
    }

    public static int[] teleport(int curr) {
        return new int[]{curr - 1, curr + 1, curr * 2};
    }

}