import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static long[] cables;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cables = new long[K];
        long start = 1;
        long end = 0;
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(bf.readLine());
            if (end < cables[i]) {
                end = cables[i];
            }
        }
        long mid = 0;
        long answer = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (count(mid) < N) {
                end = mid - 1;
            } else if (count(mid) >= N) {
                answer = mid;
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static long count(long length) {
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += cables[i] / length;
        }
        return count;
    }

}