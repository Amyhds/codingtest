import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N, A, B;
    static long[][] dots;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dots = new long[N][2];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] == o2[0]) {
                    return (int) (o1[1] - o2[1]);
                } else {
                    return (int) (o1[0] - o2[0]);
                }
            }
        });
        long answer = 0;
        for (int i = 0; i < N; i++) {
            long[] dot = dots[i];
            if (find(dot, 1) && find(dot, 2) && find(dot, 3)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean find(long[] dot, int direction) {
        long addX = dot[0];
        long addY = dot[1];
        if (direction == 1) {
            addY += B;
        } else if (direction == 2) {
            addX += A;
        } else if (direction == 3) {
            addX += A;
            addY += B;
        }
        int start = 0;
        int end = N - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long[] curr = dots[mid];
            if (curr[0] == addX && curr[1] == addY) {
                return true;
            } else if (curr[0] < addX) {
                start = mid + 1;
            } else if (curr[0] > addX) {
                end = mid - 1;
            } else if (curr[0] == addX && curr[1] < addY) {
                start = mid + 1;
            } else if (curr[0] == addX && curr[1] > addY) {
                end = mid - 1;
            }
        }
        return false;
    }

}