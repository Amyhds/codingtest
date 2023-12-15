import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean isPossible = false;

        Loop: for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                for (int k = 0; k <= 300; k++) {
                    if (i * A + j * B + k * C == N) {
                        isPossible = true;
                        break Loop;
                    }
                }
            }
        }

        System.out.println(isPossible? 1 : 0);

    }
}