import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, money, min;
    static int[] fee, parents;
    static boolean[][] friends;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());
        fee = new int[N + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            fee[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        visited = new boolean[N + 1];
        parents = new int[N + 1];
        reset();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] == i) {
                sum += fee[i];
            }
        }
        if (sum > money) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }
    }

    public static void reset() {
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        if (fee[x] < fee[y]) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
        return true;
    }

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}