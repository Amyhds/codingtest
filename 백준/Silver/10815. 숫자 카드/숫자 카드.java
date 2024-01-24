import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(isContains(number) + " ");
        }
        System.out.println(sb);
    }

    public static int isContains(int number) {
        int start = 0;
        int end = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (cards[mid] < number) {
                start = mid + 1;
            } else if (cards[mid] > number) {
                end = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}