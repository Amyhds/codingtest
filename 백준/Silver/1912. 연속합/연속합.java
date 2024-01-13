import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            int plus = sum[i - 1] + arr[i];
            if (plus > arr[i]) {
                sum[i] = plus;
            } else {
                sum[i] = arr[i];
            }
        }
        int answer = -200000000;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, sum[i]);
        }
        System.out.println(answer);
    }

}