import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 0;

        for (int i = 1; i <= 500; i++) {
            for (int j = 1; j <= 500; j++) {
                if (j * j + N == i * i) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}