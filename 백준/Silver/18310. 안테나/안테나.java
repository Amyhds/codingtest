import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        houses = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(houses);
        if (N % 2 == 0) {
            System.out.println(houses[N / 2 - 1]);
        } else {
            System.out.println(houses[N / 2]);
        }
    }

}