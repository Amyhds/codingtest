import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, max, maxIndex;
    static ArrayList<int[]>[] lists;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        if (N == 1) {
            System.out.println(0);
        } else {
            StringTokenizer st = null;
            int parent, child, weight;
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(bf.readLine());
                parent = Integer.parseInt(st.nextToken());
                child = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                lists[parent].add(new int[]{child, weight});
                lists[child].add(new int[]{parent, weight});
            }
            visited = new boolean[N + 1];
            dfs(1, 0);
            max = 0;
            visited = new boolean[N + 1];
            dfs(maxIndex, 0);
            System.out.println(max);
        }
    }

    public static void dfs(int start, int dist) {
        visited[start] = true;
        if (max < dist) {
            max = dist;
            maxIndex = start;
        }
        for (int[] arr : lists[start]) {
            if (!visited[arr[0]]) {
                dfs(arr[0], dist + arr[1]);
            }
        }
    }
}