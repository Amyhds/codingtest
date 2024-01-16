import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(bf.readLine());
        for (int t = 0; t < c; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            long[] sum = new long[n + 1];
            HashMap<Long, Long> map = new HashMap<>();
            st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                long mod = sum[i] % d;
                map.put(mod, map.getOrDefault(mod, 0L) + 1);
            }
            long answer = map.getOrDefault(0L, 0L);

            for (long same : map.values()
            ) {
                answer += same * (same - 1) / 2;
            }
            System.out.println(answer);
        }

    }

}