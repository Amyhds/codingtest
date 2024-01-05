import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 0;
        for (int i = 1; i <= (int) Math.sqrt(N); i++) {
            if (i * i <= N) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}