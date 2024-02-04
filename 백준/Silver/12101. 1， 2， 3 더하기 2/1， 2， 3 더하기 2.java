import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long k;
    static List<String> expressions;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        expressions = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int[] selected = new int[i];
            permutation(i, 0, selected);
        }
        Collections.sort(expressions);
        if (expressions.size() < k) {
            System.out.println(-1);
        } else {
            System.out.println(expressions.get((int) (k - 1)));
        }
    }

    public static void permutation(int pick, int cnt, int[] selected) {
        if (cnt == pick) {
            int sum = 0;
            String expression = "";
            for (int i = 0; i < pick - 1; i++) {
                sum += selected[i];
                expression += selected[i] + "+";
            }
            sum += selected[pick - 1];
            expression += selected[pick - 1];
            if (sum == n) {
                expressions.add(expression);
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            selected[cnt] = i;
            permutation(pick, cnt + 1, selected);
        }
    }

}