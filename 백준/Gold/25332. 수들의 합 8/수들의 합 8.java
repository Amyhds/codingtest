import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        long[] sum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + (A[i] - B[i]);
        }

        long answer = 0;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (sum[i] == 0) {
                answer++;
            }
            answer += map.getOrDefault(sum[i], 0L);
            map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1L);
        }

        System.out.println(answer);
    }

}