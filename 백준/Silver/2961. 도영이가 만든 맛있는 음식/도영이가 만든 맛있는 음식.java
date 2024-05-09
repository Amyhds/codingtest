import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, diffMin;
    static int[][] ingredient;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        ingredient = new int[N][2];
        diffMin = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }
        search(0, 1, 0);
        System.out.println(diffMin);
    }

    public static void search(int cnt, int sour, int bitter) {
        if (cnt == N) {
            if (sour > 0 && bitter > 0) {
                diffMin = Math.min(diffMin, Math.abs(sour - bitter));
            }
            return;
        }
        search(cnt + 1, sour * ingredient[cnt][0], bitter + ingredient[cnt][1]);
        search(cnt + 1, sour, bitter);
    }
}