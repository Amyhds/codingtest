import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] employees;
    static int[] compliments;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        employees = new ArrayList[N + 1];
        compliments = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            employees[i] = new ArrayList<>();
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss == -1) {
                continue;
            }
            employees[boss].add(i);
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(bf.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            compliments[employee] += weight;
        }
        dfs(1);
        for (int i = 1; i <= N; i++) {
            System.out.println(compliments[i]);
        }
    }

    public static void dfs(int start) {
        for (int employee : employees[start]) {
            compliments[employee] += compliments[start];
            dfs(employee);
        }
    }
}