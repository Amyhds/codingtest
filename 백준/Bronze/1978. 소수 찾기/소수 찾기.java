import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1001];
        for (int i = 1; i < 1001; i++) {
            isPrime[i] = true;
        }
        isPrime[1] = false;
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i] == false) {
                continue;
            }
            for (int j = i * i; j <= 1000; j += i) {
                isPrime[j] = false;
            }
        }
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = 0;
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime[num]) {
                answer++;
            }
        }
        System.out.println(answer);

    }

}