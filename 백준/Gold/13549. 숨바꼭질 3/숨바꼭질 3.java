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
            if (curr == K) {
                return;
            }
            if (isValid(curr * 2)) {
                queue.offer(curr * 2);
                line[curr * 2] = line[curr];
            }
            if (isValid(curr - 1)) {
                queue.offer(curr - 1);
                line[curr - 1] = line[curr] + 1;
            }
            if (isValid(curr + 1)) {
                queue.offer(curr + 1);
                line[curr + 1] = line[curr] + 1;
            }
        }
    }

    public static boolean isValid(int pos) {
        if (pos < 0 || pos > 100000 || line[pos] >= 0) {
            return false;
        }
        return true;
    }

}