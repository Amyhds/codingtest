import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        int resultTwo = findPrime(n, 2) - findPrime(m, 2) - findPrime(n - m, 2);
        int resultFive = findPrime(n, 5) - findPrime(m, 5) - findPrime(n - m, 5);
        int result = Math.min(resultTwo, resultFive);
        System.out.println(Math.max(result, 0));
    }

    public static int findPrime(long target, int prime) {
        int result = 0;
        for (int i = 1; i < 31; i++) {
            result += target / (long) Math.pow(prime, i);
        }
        return result;
    }

}