import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int cnt) {
        if (cnt == M) {
            for (int num : selected
            ) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            selected[cnt] = i;
            permutation(cnt + 1);
        }
    }

}