import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] integers;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        integers = new boolean[2000001];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        makeSubset(0, 0);
        for (int i = 1; i <= 2000000; i++) {
            if (!integers[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void makeSubset(int cnt, int sum) {
        if (cnt == N) {
            integers[sum] = true;
            return;
        }
        makeSubset(cnt + 1, sum + arr[cnt]);
        makeSubset(cnt + 1, sum);
    }

}