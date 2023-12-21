import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] points = new int[N][2];
        int total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i][0] = x;
            points[i][1] = y;
            if (i > 0) {
                total += Math.abs(points[i][0] - points[i - 1][0]) + Math.abs(
                    points[i][1] - points[i - 1][1]);
            }
        }
        int answer = total;
        for (int i = 1; i < N - 1; i++) {
            int minus = Math.abs(points[i][0] - points[i - 1][0]) + Math.abs(
                points[i][1] - points[i - 1][1]) + Math.abs(points[i + 1][0] - points[i][0])
                + Math.abs(
                points[i + 1][1] - points[i][1]);
            int plus = Math.abs(points[i + 1][0] - points[i - 1][0]) + Math.abs(
                points[i + 1][1] - points[i - 1][1]);
            int temp = total - minus + plus;
            answer = Math.min(answer, temp);
        }
        System.out.println(answer);
    }

}