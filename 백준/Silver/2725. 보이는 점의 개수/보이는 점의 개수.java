import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] visiblePoints;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(bf.readLine());
        visiblePoints = new int[1001];
        initialize();
        for (int c = 0; c < C; c++) {
            int N = Integer.parseInt(bf.readLine());
            System.out.println(visiblePoints[N]);
        }
    }

    public static void initialize() {
        visiblePoints[1] = 3;
        for (int n = 2; n <= 1000; n++) {
            int temp = 0;
            for (int k = 2; k <= n; k++) {
                if (findCD(n, k) == 1) {
                    temp++;
                }
            }
            visiblePoints[n] = visiblePoints[n - 1] + temp * 2 + 2;
        }
    }

    public static int findCD(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}