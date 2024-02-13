import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, maxProfit;
    static int[] day;
    static int[] pay;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        day = new int[N];
        pay = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }
        getMaxProfit(0, 0);
        System.out.println(maxProfit);
    }

    public static void getMaxProfit(int curr, int sum) {
        if (curr == N) {
            maxProfit = Math.max(sum, maxProfit);
            return;
        }
        if (curr + day[curr] <= N) {
            getMaxProfit(curr + day[curr], sum + pay[curr]);
        }
        getMaxProfit(curr + 1, sum);
    }

}