import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, dpIncrease, dpDecrease;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dpIncrease = new int[N + 1];
        dpDecrease = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dpIncrease[i] = 1;
            dpDecrease[i] = 1;
        }
        increase();
        decrease();
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dpIncrease[i] + dpDecrease[i] - 1);
        }
        System.out.println(max);
    }

    public static void increase() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    dpIncrease[i] = Math.max(dpIncrease[j] + 1, dpIncrease[i]);
                }
            }
        }
    }

    public static void decrease() {
        for (int i = N; i >= 1; i--) {
            for (int j = N; j >= i; j--) {
                if (arr[j] < arr[i]) {
                    dpDecrease[i] = Math.max(dpDecrease[j] + 1, dpDecrease[i]);
                }
            }
        }
    }

}