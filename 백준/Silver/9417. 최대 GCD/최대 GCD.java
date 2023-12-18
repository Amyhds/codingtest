import java.io.*;
import java.util.*;

public class Main {

    static int answer;
    static List<Integer> list;
    static int[] chosen;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int t = 0; t < N; t++) {
            answer = 0;
            list = new ArrayList<>();
            chosen = new int[2];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            comb(0, 0);
            System.out.println(answer);
        }
    }

    public static void comb(int cnt, int start) {
        if (cnt == 2) {
            int gcd = GCD(chosen[0], chosen[1]);
            answer = Math.max(answer, gcd);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            chosen[cnt] = list.get(i);
            comb(cnt + 1, i + 1);
        }
    }

    public static int GCD(int a, int b) {
        int small = 0;
        int big = 0;
        if (a < b) {
            small = a;
            big = b;
        } else {
            small = b;
            big = a;
        }
        while (small != 0) {
            int remain = big % small;
            big = small;
            small = remain;
        }
        return big;
    }
}