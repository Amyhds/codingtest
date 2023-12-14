import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int tempN = N;
        int tempM = M;

        while(true) {
            tempN -= 2;
            tempM -= 1;
            if (tempN >= 0 && tempM >= 0 && tempN + tempM >= K) {
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }
}