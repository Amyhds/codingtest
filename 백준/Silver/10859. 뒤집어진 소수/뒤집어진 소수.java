import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] upsideDown = {0, 1, 2, -1, -1, 5, 9, -1, 8, 6};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine());
        long reversedN = reverse(N);
        if (reversedN == -1L) {
            System.out.println("no");
        } else {
            if (isPrime(N) && isPrime(reversedN)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean isPrime(long target) {
        if (target == 1) {
            return false;
        }
        for (long i = 2; i <= (long) Math.sqrt(target); i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long reverse(long num) {
        int size = String.valueOf(num).length();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            int digit = (int) ((num % (long) Math.pow(10, i)) / (long) Math.pow(10, i - 1));
            if (digit == 3 || digit == 4 || digit == 7) {
                return -1L;
            } else {
                result.append(upsideDown[digit]);
            }
        }
        return Long.parseLong(String.valueOf(result));
    }
}