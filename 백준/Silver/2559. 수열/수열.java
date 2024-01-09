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
        int[] sum = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                sum[i] = Integer.parseInt(st.nextToken());
            } else {
                int temperature = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + temperature;
            }
        }
        int max = sum[K - 1];
        int temp = 0;
        for (int i = K; i < N; i++) {
            temp = sum[i] - sum[i - K];
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }

}