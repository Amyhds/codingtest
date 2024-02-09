import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] answers, selected;
    static int cases;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        answers = new int[10];
        selected = new int[10];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 10; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }
        cases = 0;
        search(0);
        System.out.println(cases);
    }

    public static void search(int cnt) {
        if (cnt == 10) {
            if (mark() >= 5) {
                cases++;
            }
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (cnt > 1 && selected[cnt - 2] == selected[cnt - 1] && selected[cnt - 1] == i) {
                continue;
            }
            selected[cnt] = i;
            search(cnt + 1);
        }
    }

    public static int mark() {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            if (answers[i] == selected[i]) {
                score++;
            }
        }
        return score;
    }

}