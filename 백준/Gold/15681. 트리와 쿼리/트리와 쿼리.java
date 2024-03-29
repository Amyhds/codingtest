import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, R, Q;
    static ArrayList<Integer>[] graph;
    static int[] subTree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        subTree = new int[N + 1];
        solution(R, 0);
        for (int i = 0; i < Q; i++) {
            int root = Integer.parseInt(bf.readLine());
            System.out.println(subTree[root]);
        }
    }

    public static void solution(int curr, int prev) {
        subTree[curr] = 1;
        for (int child : graph[curr]) {
            if (child != prev) {
                solution(child, curr);
                subTree[curr] += subTree[child];
            }
        }
    }
}