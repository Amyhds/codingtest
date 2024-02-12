import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, max;
    static int[][] dailyQuest;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dailyQuest = new int[M][K];
        for (int quest = 0; quest < M; quest++) {
            st = new StringTokenizer(bf.readLine());
            for (int skill = 0; skill < K; skill++) {
                dailyQuest[quest][skill] = Integer.parseInt(st.nextToken());
            }
        }
        makeSubset(0, 1, new int[N]);
        System.out.println(max);
    }

    public static void makeSubset(int cnt, int start, int[] selected) {
        if (cnt == N) {
            max = Math.max(max, complete(selected));
            return;
        }
        for (int num = start; num <= 2 * N; num++) {
            selected[cnt] = num;
            makeSubset(cnt + 1, num + 1, selected);
        }
    }

    public static int complete(int[] selected) {
        int score = 0;
        for (int quest = 0; quest < M; quest++) {
            int daily = 0;
            for (int skill = 0; skill < K; skill++) {
                for (int i = 0; i < N; i++) {
                    if (dailyQuest[quest][skill] == selected[i]) {
                        daily++;
                    }
                }
            }
            if (daily == K) {
                score++;
            }
        }
        return score;
    }

}