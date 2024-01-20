import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 2) {
            System.out.println(solutions[0] + " " + solutions[1]);
        } else {
            int start = 0;
            int end = N - 1;
            int index1 = 0;
            int index2 = 0;
            int min = Integer.MAX_VALUE;
            while (start < end) {
                int mixture = solutions[start] + solutions[end];
                if (min > Math.abs(mixture)) {
                    min = Math.abs(mixture);
                    index1 = start;
                    index2 = end;
                }
                if (mixture < 0) {
                    start++;
                } else {
                    end--;
                }
            }
            System.out.println(solutions[index1] + " " + solutions[index2]);
        }
    }
}