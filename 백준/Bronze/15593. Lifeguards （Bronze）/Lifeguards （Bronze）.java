import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 0;
        int total = 0;
        int[] time = new int[1000];
        int[][] cows = new int[N][2];

        StringTokenizer st = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            cows[i][0] = start;
            cows[i][1] = end;
            for(int j = start; j < end; j++) {
                if (time[j] == 0) {
                    total++;
                }
                time[j]++;
            }
        }

        for(int i = 0; i < N; i++) {
            int start = cows[i][0];
            int end = cows[i][1];
            int temp = 0;
            for (int j = start; j < end; j++) {
                if (time[j] <= 1) {
                    temp++;
                }
            }
            answer = Math.max(answer, total - temp);
        }

        System.out.println(answer);
    }
}