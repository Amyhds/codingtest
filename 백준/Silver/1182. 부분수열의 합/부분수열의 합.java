import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, answer;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        search(0, 0);
        System.out.println(S == 0 ? answer - 1 : answer);
    }

    public static void search(int cnt, int sum) {
        if (cnt == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }
        search(cnt + 1, sum);
        search(cnt + 1, sum + array[cnt]);
    }
}