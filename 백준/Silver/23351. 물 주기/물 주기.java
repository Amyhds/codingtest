import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] catnips = new int[N];
        for (int i = 0; i < N; i++) {
            catnips[i] = K;
        }
        int index = 0;
        int answer = 0;
        Loop:
        while (true) {
            answer++;
            for (int i = index; i < index + A; i++) {
                catnips[i] += B;
            }
            for (int i = 0; i < N; i++) {
                catnips[i]--;
            }
            for (int catnip : catnips
            ) {
                if (catnip == 0) {
                    break Loop;
                }
            }
            index += A;
            if (index == N) {
                index = 0;
            }
        }
        System.out.println(answer);
    }

}