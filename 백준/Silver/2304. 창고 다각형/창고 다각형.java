import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int N;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][2];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int maxHeight = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            if (maxHeight < arr[i][1]) {
                maxHeight = arr[i][1];
                maxIndex = i;
            }
        }
        for (int i = 0; i < maxIndex; i++) {
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
        System.out.println(answer + maxHeight);
    }

}