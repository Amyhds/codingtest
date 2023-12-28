import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] nums = new String[N];
        int[][] arr = new int[N][2];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            nums[i] = num;
            arr[i][0] = strike;
            arr[i][1] = ball;
        }
        for (int i = 123; i <= 987; i++) {
            String testNum = String.valueOf(i);
            if (!isValidNum(testNum)) {
                continue;
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (findStrike(testNum, nums[j]) == arr[j][0]
                    && findBall(testNum, nums[j]) == arr[j][1]) {
                    cnt++;
                }
            }
            if (cnt == N) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean isValidNum(String target) {
        if (target.contains("0")) {
            return false;
        }
        if (target.charAt(0) == target.charAt(1) || target.charAt(0) == target.charAt(2)
            || target.charAt(1) == target.charAt(2)) {
            return false;
        }
        return true;
    }

    public static int findStrike(String target, String ask) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (target.charAt(i) == ask.charAt(j)) {
                    if (i == j) {
                        strike++;
                    }
                }
            }
        }
        return strike;
    }

    public static int findBall(String target, String ask) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (target.charAt(i) == ask.charAt(j)) {
                    if (i != j) {
                        ball++;
                    }
                }
            }
        }
        return ball;
    }

}