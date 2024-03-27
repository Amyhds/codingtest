import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = null;
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        parent = new int[N + 1];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        solution(1, 0);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void solution(int start, int prev) {
        for (int node : arr[start]
        ) {
            if (node != prev) {
                parent[node] = start;
                solution(node, start);
            }
        }
    }

}