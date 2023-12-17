import java.io.*;
import java.util.*;

public class Main {

    static int[][] pos = new int[4][2];
    static boolean[] isVisited = new boolean[4];
    static List<Double> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i][0] = x;
            pos[i][1] = y;
        }
        isVisited[0] = true;
        move(0, 0, 0);
        Collections.sort(results);
        System.out.println((int) Math.floor(results.get(0)));

    }

    public static void move(int cnt, double total, int lastIndex) {
        if (cnt == 3) {
            results.add(total);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                move(cnt + 1, total + calculate(pos[lastIndex], pos[i]), i);
                isVisited[i] = false;
            }
        }
    }

    public static double calculate(int[] pos1, int[] pos2) {
        return Math.sqrt(Math.pow(pos1[0] - pos2[0], 2) + Math.pow(pos1[1] - pos2[1], 2));
    }
}