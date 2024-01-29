import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dots;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(bf.readLine());
            dots = new int[N];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                dots[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(dots);
            int answer = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (find(j, dots[j] - dots[i])) {
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static boolean find(int middleIndex, int diffAB) {
        int start = middleIndex;
        int end = N - 1;
        int mid, diffBC;
        while (start <= end) {
            mid = (start + end) / 2;
            diffBC = dots[mid] - dots[middleIndex];
            if (diffBC < diffAB) {
                start = mid + 1;
            } else if (diffBC > diffAB) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}