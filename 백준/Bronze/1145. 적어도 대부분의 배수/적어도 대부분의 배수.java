import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer = 0;
        int count = 0;
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            answer++;
            for (int i = 0; i < 5; i++) {
                if (answer % numbers[i] == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(answer);
                break;
            } else {
                count = 0;
            }
        }
    }
}