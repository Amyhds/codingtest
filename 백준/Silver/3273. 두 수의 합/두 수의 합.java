import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(bf.readLine());

        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;
        int answer = 0;
        while (start < N && end < N && start < end) {
            int temp = arr[start] + arr[end];
            if (temp == X) {
                answer++;
                start++;
                end--;
            } else if (temp > X) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(answer);
    }

}