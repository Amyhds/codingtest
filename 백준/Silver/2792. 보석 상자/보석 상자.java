import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] box = new int[M];
        int end = 0;
        for (int i = 0; i < M; i++) {
            box[i] = Integer.parseInt(bf.readLine());
            end = Math.max(end, box[i]);
        }
        int start = 1;
        int count, mid;
        int answer = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            count = 0;
            for (int i = 0; i < M; i++) {
                int remain = box[i] % mid;
                int share = box[i] / mid;
                if (remain == 0) {
                    count += share;
                } else {
                    count += share + 1;
                }
            }
            if (count > N) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

}