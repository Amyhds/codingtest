import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int n = 0; n < N; n++) {
            long num = Long.parseLong(bf.readLine());
            boolean isPassword = true;
            for (long i = 2; i <= 1000001; i++) {
                if (num % i == 0) {
                    isPassword = false;
                    System.out.println("NO");
                    break;
                }
            }
            if (isPassword) {
                System.out.println("YES");
            }
        }
    }
}