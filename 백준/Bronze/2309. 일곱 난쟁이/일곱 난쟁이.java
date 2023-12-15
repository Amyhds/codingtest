import java.io.*;
import java.util.*;

public class Main {

    static int total = 0;
    static int[] dwarfs = new int[9];
    static int[] chosen = new int[2];
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(bf.readLine());
            total += height;
            dwarfs[i] = height;
        }

        int out1 = 0;
        int out2 = 0;
        int index1 = -1;
        int index2 = -1;

        Loop: for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                out1 = dwarfs[i];
                out2 = dwarfs[j];
                if (total - out1 - out2 == 100) {
                    index1 = i;
                    index2 = j;
                    break Loop;
                }

            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == index1 || i == index2) {
                continue;
            }
            answer.add(dwarfs[i]);
        }

        Collections.sort(answer);
        for (int height : answer
        ) {
            System.out.println(height);
        }
    }
}