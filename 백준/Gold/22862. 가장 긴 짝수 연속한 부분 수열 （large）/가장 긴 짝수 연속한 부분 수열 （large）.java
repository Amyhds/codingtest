import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution());
    }

    public static int solution() {
        int start = 0;
        int end = 0;
        int odd = 0;
        int max = 0;

        while (end < N) {
            if (odd < K) {
                if (arr[end] % 2 == 1) {
                    odd++;
                }
                end++;
            } else if (arr[end] % 2 == 0) {
                end++;
            } else {
                if (arr[start] % 2 == 1) {
                    odd--;
                }
                start++;
            }
            max = Math.max(max, end - start - odd);
        }
        return max;
    }

}