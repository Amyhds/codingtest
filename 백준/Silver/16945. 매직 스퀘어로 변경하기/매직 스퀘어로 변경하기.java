import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[10];
        answer = Integer.MAX_VALUE;
        int[][] newArr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            newArr[i] = arr[i].clone();
        }
        recur(0, 0, 0, newArr);
        System.out.println(answer);
    }

    public static void recur(int x, int y, int cost, int[][] newArr) {
        if (y == 3) {
            y = 0;
            x += 1;
        }
        if (x == 3) {
            if (isMagicSquare(newArr)) {
                answer = Math.min(answer, cost);
            }
            return;
        }
        for (int n = 1; n <= 9; n++) {
            if (!visited[n]) {
                visited[n] = true;
                newArr[x][y] = n;
                recur(x, y + 1, cost + Math.abs(arr[x][y] - n), newArr);
                visited[n] = false;
            }
        }
    }

    public static boolean isMagicSquare(int[][] newArr) {
        int[] horizon = new int[3];
        int[] vertical = new int[3];
        int[] diagonal = new int[2];
        // horizon
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                horizon[i] += newArr[i][j];
            }
            if (horizon[i] != 15) {
                return false;
            }
        }
        // vertical
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                vertical[i] += newArr[j][i];
            }
            if (vertical[i] != 15) {
                return false;
            }
        }
        // diagonal
        for (int i = 0; i < 3; i++) {
            diagonal[0] += newArr[i][i];
            diagonal[1] += newArr[i][2 - i];
        }
        if (diagonal[0] != 15 || diagonal[1] != 15) {
            return false;
        }
        return true;
    }
}