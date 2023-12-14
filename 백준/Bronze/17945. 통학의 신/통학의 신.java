import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Loop: for (int i = -1000; i <= 1000; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (i + j == - 1 * A * 2 && i * j == B) {
                    if (i < j) {
                        System.out.println(i + " " + j);
                    } else if (i > j) {
                        System.out.println(j + " " + i);
                    } else {
                        System.out.println(i);
                    }
                    break Loop;
                }
            }
        }
    }
}