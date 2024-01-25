import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static long[] makgeol;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        makgeol = new long[N];
        long max = 0;
        for (int i = 0; i < N; i++) {
            makgeol[i] = Integer.parseInt(bf.readLine());
            if (max < makgeol[i]) {
                max = makgeol[i];
            }
        }
        long start = 0;
        long end = max;
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long glasses = count(mid);
            if (glasses < K) {
                end = mid - 1;
            } else if (glasses >= K) {
                answer = mid;
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static long count(long volume) {
        long glasses = 0;
        if (volume == 0) {
            for (int i = 0; i < N; i++) {
                glasses += makgeol[i];
            }
        } else {
            for (int i = 0; i < N; i++) {
                glasses += makgeol[i] / volume;
            }
        }
        return glasses;
    }
}