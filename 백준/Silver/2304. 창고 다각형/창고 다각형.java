import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (max < arr[i][1]) {
                max = arr[i][1];
                maxIndex = i;
            }
        }
        int answer = 0;
        for (int i = 0; i <= maxIndex; i++) {
            for (int j = i + 1; j <= maxIndex; j++) {
                if (arr[i][1] <= arr[j][1]) {
                    answer += (arr[j][0] - arr[i][0]) * arr[i][1];
                    i = j;
                }
            }
        }

        for (int i = N - 1; i > maxIndex; i--) {
            for (int j = i - 1; j >= maxIndex; j--) {
                if (arr[i][1] <= arr[j][1]) {
                    answer += (arr[i][0] - arr[j][0]) * arr[i][1];
                    i = j;
                }
            }
        }
        System.out.println(answer + max);
    }

}