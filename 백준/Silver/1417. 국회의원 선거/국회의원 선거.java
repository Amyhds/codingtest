import java.io.*;
import java.util.*;

public class Main {

    static Integer[] votes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        if (N == 1) {
            System.out.println(0);
        } else {
            votes = new Integer[N - 1];
            int dasom = Integer.parseInt(bf.readLine());
            int answer = 0;
            for (int i = 0; i < N - 1; i++) {
                votes[i] = Integer.parseInt(bf.readLine());
            }
            int index = 0;
            while (true) {
                Arrays.sort(votes, Comparator.reverseOrder());
                if (index == N - 1) {
                    if (dasom > votes[0]) {
                        break;
                    } else {
                        index = 0;
                    }
                }
                if (dasom <= votes[index]) {
                    dasom++;
                    votes[index]--;
                    answer++;
                } else {
                    index++;
                }
            }
            System.out.println(answer);
        }
    }
}