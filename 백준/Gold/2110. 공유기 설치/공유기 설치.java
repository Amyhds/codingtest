import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(houses);
        int answer = 0;
        int start = 1;
        int end = houses[N - 1] - houses[0];
        while (start <= end) {
            int mid = (start + end) / 2;
            int router = count(mid);
            if (router < C) {
                end = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static int count(int distance) {
        int router = 1;
        int last = houses[0];
        for (int i = 1; i < N; i++) {
            if (houses[i] - last >= distance) {
                router++;
                last = houses[i];
            }
        }
        return router;
    }

}