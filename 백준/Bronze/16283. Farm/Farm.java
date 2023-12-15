import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int sheep = 0;
        int goat = 0;
        int answer = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if(a * i + b * j == w && i + j == n) {
                    sheep = i;
                    goat = j;
                    answer++;
                }
            }
        }

        if(answer == 0 || answer > 1) {
            System.out.println(-1);
        } else {
            System.out.println(sheep + " " + goat);
        }
    }
}