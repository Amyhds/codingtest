import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long N = Long.parseLong(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        if (N == 0 || N == 1) {
            System.out.println(0);
        } else {
            int answer = 0;
            for (int i = 1; i < 31; i++) {
                answer += N / (long) Math.pow(A, i);
            }
            System.out.println(answer);
        }
    }
}