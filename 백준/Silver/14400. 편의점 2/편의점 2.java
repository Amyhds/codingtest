import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] clientsX = new int[N];
        int[] clientsY = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            clientsX[i] = x;
            clientsY[i] = y;
        }
        Arrays.sort(clientsX);
        Arrays.sort(clientsY);
        int cvsX = clientsX[N / 2];
        int cvsY = clientsY[N / 2];
        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.abs(clientsX[i] - cvsX);
            answer += Math.abs(clientsY[i] - cvsY);
        }
        System.out.println(answer);
    }

}