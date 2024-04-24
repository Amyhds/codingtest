import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, K, answer;
    static int[][] stats;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stats = new int[N][3];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            stats[i][0] = Integer.parseInt(st.nextToken());
            stats[i][1] = Integer.parseInt(st.nextToken());
            stats[i][2] = Integer.parseInt(st.nextToken());
        }
        comb(0, new int[]{0, 0, 0});
        System.out.println(answer);
    }

    public static void comb(int cnt, int[] jinsu) {
        if (cnt == 3) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (jinsu[0] >= stats[i][0] && jinsu[1] >= stats[i][1] && jinsu[2] >= stats[i][2]) {
                    count++;
                }
            }
            if (count >= K) {
                answer = Math.min(answer, jinsu[0] + jinsu[1] + jinsu[2]);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            jinsu[cnt] = stats[i][cnt];
            comb(cnt + 1, jinsu);
        }
    }
}