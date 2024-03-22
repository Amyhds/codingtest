import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static char[] arr;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static char[] candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        candidate = new char[L];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        combination(0, 0);
    }

    public static void combination(int cnt, int start) {
        if (cnt == L) {
            if (hasVowel() && hasConsonants()) {
                for (char letter : candidate) {
                    System.out.print(letter);
                }
                System.out.println();
            }
            return;
        }
        for (int i = start; i < C; i++) {
            candidate[cnt] = arr[i];
            combination(cnt + 1, i + 1);
        }
    }

    public static boolean hasVowel() {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < 5; j++) {
                if (candidate[i] == vowels[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasConsonants() {
        int cnt = 0;
        for (int i = 0; i < L; i++) {
            if (candidate[i] != 'a' && candidate[i] != 'e' && candidate[i] != 'i'
                && candidate[i] != 'o' && candidate[i] != 'u') {
                cnt++;
            }
        }
        if (cnt >= 2) {
            return true;
        }
        return false;
    }
}