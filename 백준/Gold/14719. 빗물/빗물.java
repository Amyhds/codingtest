import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[W];
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int cur = 1; cur < W - 1; cur++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int left = 0; left < cur; left++) {
                leftMax = Math.max(leftMax, arr[left]);
            }
            for (int right = cur + 1; right < W; right++) {
                rightMax = Math.max(rightMax, arr[right]);
            }
            answer += Math.max(0, Math.min(leftMax, rightMax) - arr[cur]);
        }
        System.out.println(answer);
    }

}