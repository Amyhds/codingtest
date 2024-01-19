import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] lights = new int[N + 1];

        for (int b = 0; b < B; b++) {
            int broken = Integer.parseInt(bf.readLine());
            lights[broken] = 1;
        }

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + lights[i];
        }

        int start = 1;
        int end = K;
        int min = Integer.MAX_VALUE;
        while (end <= N) {
            int brokens = sum[end] - sum[start - 1];
            min = Math.min(min, brokens);
            start++;
            end++;
        }
        System.out.println(min);

    }
}