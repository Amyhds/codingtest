import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int K;
    static String[] signs;
    static boolean[] visited;
    static List<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        signs = bf.readLine().split(" ");
        visited = new boolean[10];
        results = new ArrayList<>();
        combination("", 0);
        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    public static void combination(String num, int cnt) {
        if (cnt == K + 1) {
            results.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            if (cnt == 0 || isValid(Character.getNumericValue(num.charAt(cnt - 1)), i,
                signs[cnt - 1])) {
                visited[i] = true;
                combination(num + i, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isValid(int left, int right, String sign) {
        if (sign.equals(">")) {
            if (left < right) {
                return false;
            }
        } else {
            if (left > right) {
                return false;
            }
        }
        return true;
    }
}