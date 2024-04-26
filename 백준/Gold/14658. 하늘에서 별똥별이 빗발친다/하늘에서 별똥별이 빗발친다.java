import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, L, K;
    static int[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stars = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken()); // 좌표계로 생각
            stars[i][1] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        for (int[] s1 : stars) {
            for (int[] s2 : stars) {
                answer = Math.min(answer, getFallenStars(s1[0], s2[1]));
            }
        }
        System.out.println(answer);
    }

    public static int getFallenStars(int x, int y) {
        int nx = x + L;
        int ny = y + L;
        int fallenStars = K;
        for (int i = 0; i < K; i++) {
            if (stars[i][0] >= x && stars[i][0] <= nx && stars[i][1] >= y && stars[i][1] <= ny) {
                fallenStars--;
            }
        }
        return fallenStars;
    }
}