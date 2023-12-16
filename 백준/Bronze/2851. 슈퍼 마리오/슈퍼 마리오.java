import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] mushrooms = new int[10];
        for (int i = 0; i < 10; i++) {
            mushrooms[i] = Integer.parseInt(bf.readLine());
        }
        int total = 0;
        int[] diff = new int[10];
        boolean[] isMinus = new boolean[10];
        for (int i = 0; i < 10; i++) {
            total += mushrooms[i];
            diff[i] = Math.abs(100 - total);
            if (100 - total < 0) {
                isMinus[i] = true;
            }
        }

        int minDiff = 1000000;
        int minIndex = -1;

        for (int i = 0; i < 10; i++) {
            if (minDiff >= diff[i]) {
                minDiff = diff[i];
                minIndex = i;
            }
        }

        if (isMinus[minIndex]) {
            System.out.println(100 + minDiff);
        } else {
            System.out.println(100 - minDiff);
        }

    }
}