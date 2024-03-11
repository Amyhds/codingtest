import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        visited = new boolean[N + 1];
        list = new ArrayList<>();
        for (int curr = 1; curr <= N; curr++) {
            visited[curr] = true;
            dfs(curr, curr);
            visited[curr] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int num : list) {
            System.out.println(num);
        }
    }

    public static void dfs(int curr, int start) {
        int next = arr[curr];
        if (!visited[next]) {
            visited[next] = true;
            dfs(next, start);
            visited[next] = false;
        }
        if (arr[curr] == start) {
            list.add(start);
        }
    }

}