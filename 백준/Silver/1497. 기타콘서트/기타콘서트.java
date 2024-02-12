import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[][] playTable;
    static int[] minGuitar;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        playTable = new boolean[N][M];
        minGuitar = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            minGuitar[i] = Integer.MAX_VALUE;
        }
        for (int g = 0; g < N; g++) {
            st = new StringTokenizer(bf.readLine());
            String guitar = st.nextToken();
            String information = st.nextToken();
            for (int s = 0; s < M; s++) {
                if (information.charAt(s) == 'Y') {
                    playTable[g][s] = true;
                }
            }
        }
        calculate(0, new boolean[N]);
        int result = 0;
        for (int s = M; s >= 1; s--) {
            if (minGuitar[s] != Integer.MAX_VALUE) {
                result = minGuitar[s];
                break;
            }
        }
        System.out.println(result == 0 ? -1 : result);
    }

    public static void calculate(int cnt, boolean[] selected) {
        if (cnt == N) {
            int[] result = getPlayable(selected);
            int song = result[1];
            int guitar = result[0];
            if (minGuitar[song] > guitar) {
                minGuitar[song] = guitar;
            }
            return;
        }
        selected[cnt] = true;
        calculate(cnt + 1, selected);
        selected[cnt] = false;
        calculate(cnt + 1, selected);
    }

    public static int[] getPlayable(boolean[] selected) {
        boolean[] total = new boolean[M];
        int guitar = 0;
        for (int g = 0; g < N; g++) {
            if (!selected[g]) {
                continue;
            }
            guitar++;
            for (int s = 0; s < M; s++) {
                if (total[s]) {
                    continue;
                }
                if (playTable[g][s]) {
                    total[s] = true;
                }
            }
        }
        int song = 0;
        for (int s = 0; s < M; s++) {
            if (total[s]) {
                song++;
            }
        }
        return new int[]{guitar, song};
    }
}