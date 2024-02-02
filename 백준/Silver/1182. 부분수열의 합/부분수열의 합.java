import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, answer;
    static int[] array, selected;

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
        for (int size = 1; size <= N; size++) {
            int[] selected = new int[size];
            select(0, 0, size, selected);
        }
        System.out.println(answer);
    }

    public static void select(int cnt, int start, int size, int[] selected) {
        if (cnt == size) {
            int result = 0;
            for (int i = 0; i < size; i++) {
                result += selected[i];
            }
            if (result == S) {
                answer++;
            }
            return;
        }
        for (int i = start; i < N; i++) {
            selected[cnt] = array[i];
            select(cnt + 1, i + 1, size, selected);
        }
    }
}