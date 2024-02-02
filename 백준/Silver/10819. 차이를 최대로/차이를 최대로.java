import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static int[] array, selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        array = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        selected = new int[N];
        visited = new boolean[N];
        answer = 0;
        permutation(0);
        System.out.println(answer);
    }

    public static void permutation(int cnt) {
        if (cnt == N) {
            int result = 0;
            for (int i = 1; i < N; i++) {
                result += Math.abs(selected[i] - selected[i - 1]);
            }
            answer = Math.max(answer, result);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            selected[cnt] = array[i];
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
}