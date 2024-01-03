import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long Aminus1 = Long.parseLong(st.nextToken()) - 1L;
        long B = Long.parseLong(st.nextToken());
        int squareAminus1 = findSquare(Aminus1);
        int sqaureB = findSquare(B);
        System.out.println(sum(B, sqaureB) - sum(Aminus1, squareAminus1));
    }

    public static int findSquare(long num) {
        int square = 0;
        long start = 1;
        while (start < num) {
            start *= 2;
            square++;
        }
        if ((long) Math.pow(2, square) == num) {
            return square;
        } else {
            return square - 1;
        }
    }

    public static long sum(long num, int square) {
        long result = num;
        for (int i = 1; i <= square; i++) {
            result += (num / (long) Math.pow(2, i)) * (long) Math.pow(2, i - 1);
        }
        return result;
    }
}