import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max, min;
    static int[] array, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        array = new int[N];
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        dfs(1, array[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int cnt, int result) {
        if (cnt == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(cnt + 1, result + array[cnt]);
                        break;
                    case 1:
                        dfs(cnt + 1, result - array[cnt]);
                        break;
                    case 2:
                        dfs(cnt + 1, result * array[cnt]);
                        break;
                    case 3:
                        dfs(cnt + 1, result / array[cnt]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}