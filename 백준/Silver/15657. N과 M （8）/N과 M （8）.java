import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] array;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
//        visited = new boolean[N];
        selected = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        permutation(0, 0);
        System.out.println(sb);
    }

    public static void permutation(int cnt, int start) {
        if (cnt == M) {
            for (int num : selected
            ) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
//            if (visited[i]) {
//                continue;
//            }
//            visited[i] = true;
            selected[cnt] = array[i];
            permutation(cnt + 1, i);
//            visited[i] = false;
        }
    }

}