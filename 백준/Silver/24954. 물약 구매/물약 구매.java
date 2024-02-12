import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, cheapest;
    static int[] prices;
    static List<int[]>[] discounts;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        prices = new int[N];
        discounts = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            discounts[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(bf.readLine());
            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(bf.readLine());
                int potion = Integer.parseInt(st.nextToken());
                int discount = Integer.parseInt(st.nextToken());
                discounts[i].add(new int[]{potion, discount});
            }
        }
        cheapest = Integer.MAX_VALUE;
        calculate(0, new int[N], new boolean[N]);
        System.out.println(cheapest);
    }

    public static void calculate(int cnt, int[] seq, boolean[] visited) {
        if (cnt == N) {
            cheapest = Math.min(cheapest, purchase(seq));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            seq[cnt] = i;
            calculate(cnt + 1, seq, visited);
            visited[i] = false;
        }
    }

    public static int purchase(int[] seq) {
        int[] newPrices = new int[N];
        for (int i = 0; i < N; i++) {
            newPrices[i] = prices[i];
        }
        int coin = 0;
        for (int s = 0; s < N; s++) {
            int idx = seq[s];
            coin += newPrices[idx];
            int range = discounts[idx].size();
            for (int r = 0; r < range; r++) {
                int[] temp = discounts[idx].get(r);
                int potion = temp[0];
                int discount = temp[1];
                if (newPrices[potion - 1] - discount <= 0) {
                    newPrices[potion - 1] = 1;
                } else {
                    newPrices[potion - 1] -= discount;
                }
            }
        }
        return coin;
    }
}