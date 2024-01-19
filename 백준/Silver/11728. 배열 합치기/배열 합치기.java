import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        int pointA = 0;
        int pointB = 0;
        while (pointA < N && pointB < M) {
            if (A[pointA] < B[pointB]) {
                sb.append(A[pointA] + " ");
                pointA++;
            } else {
                sb.append(B[pointB] + " ");
                pointB++;
            }
        }
        if (pointA == N) {
            for (int i = pointB; i < M; i++) {
                sb.append(B[i] + " ");
            }
        }
        if (pointB == M) {
            for (int i = pointA; i < N; i++) {
                sb.append(A[i] + " ");
            }
        }
        System.out.println(sb);

    }

}