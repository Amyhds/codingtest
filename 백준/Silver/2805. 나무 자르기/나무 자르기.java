import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, max, answer;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(bf.readLine());
        max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (max < trees[i]) {
                max = trees[i];
            }
        }

        answer = 0;
        int start = 0;
        int end = max;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long result = cut(mid);
            if (result < M) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static long cut(int cutter) {
        long height = 0;
        for (int i = 0; i < N; i++) {
            int remain = trees[i] - cutter;
            if (remain > 0) {
                height += remain;
            }
        }
        return height;
    }

}