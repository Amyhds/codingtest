import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temps = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            temps[i] = Integer.parseInt(st.nextToken());
        }

        int max = -10000;
        for (int i = 0; i < N - K + 1; i++) {
            int section = 0;
            for (int j = 0; j < K; j++) {
                section += temps[i + j];
            }
            max = Math.max(max, section);
        }
        System.out.println(max);
    }
}