import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] bottom = new int[H + 1];
        int[] top = new int[H + 1];
        for (int i = 1; i <= N / 2; i++) {
            bottom[Integer.parseInt(bf.readLine())]++;
            top[H - Integer.parseInt(bf.readLine())
                + 1]++; // <- 거꾸로 매달려있으므로 높이와의 차에 +1을 해줘야 지나가는 구간을 뜻함(?)
        }
        // 석순
        for (int i = H; i >= 1; i--) {  // 0  1  2  3  4  5  6  7 <- 높이
            bottom[i - 1] += bottom[i]; // 0  1  0  1  0  1  0  0 <- 석순 체크
        }                               // 0  3  2  2  1  1  0  0 <- i번째 구간을 지날 때 부딪히는 횟수
        // 종유석
        for (int i = 1; i <= H; i++) {  // 0  1  2  3  4  5  6  7 <- 높이
            top[i] += top[i - 1];       // 0  0  0  1  0  1  0  1 <- 종유석 체크
        }                               // 0  0  0  1  1  2  2  3 <- i번째 구간을 지날 때 부딪히는 횟수
        int min = Integer.MAX_VALUE;
        int[] results = new int[H + 1];
        for (int i = 1; i <= H; i++) {
            results[i] = bottom[i] + top[i];
            min = Math.min(min, results[i]);
        }
        int count = 0;
        for (int i = 1; i <= H; i++) {
            if (results[i] == min) {
                count++;
            }
        }
        System.out.println(min + " " + count);
    }

}