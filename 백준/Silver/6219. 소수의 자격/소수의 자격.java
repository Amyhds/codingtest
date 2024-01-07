import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, D;
    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        findPrime();
        int answer = 0;
        for (int target = A; target <= B; target++) {
            if (!isNotPrime[target] && isContainD(target)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void findPrime() {
        isNotPrime = new boolean[B + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <= (int) Math.sqrt(B); i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= B; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    public static boolean isContainD(int target) {
        int size = String.valueOf(target).length();
        int num = 0;
        for (int i = 1; i <= size; i++) {
            num = (target % (int) Math.pow(10, i)) / (int) Math.pow(10, i - 1);
            if (num == D) {
                return true;
            }
            target -= num * (int) Math.pow(10, i - 1);
        }
        return false;
    }
}