import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, count;
    static long k;
    static int[] arr;
    static boolean isValid;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        count = 0;
        arr = new int[11];
        func(0, 0);
        if (isValid) {
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }

    public static void func(int sum, int length) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            count++;
            if (count == k) {
                isValid = true;
                for (int i = 0; i < length - 1; i++) {
                    sb.append(arr[i] + "+");
                }
                sb.append(arr[length - 1]);
            }
            return;
        }
        for (int num = 1; num <= 3; num++) {
            arr[length] = num;
            func(sum + num, length + 1);
        }
    }

}