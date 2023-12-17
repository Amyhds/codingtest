import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            bf.readLine();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][] box = new char[r][c];
            for (int i = 0; i < r; i++) {
                String temp = bf.readLine();
                for (int j = 0; j < c; j++) {
                    box[i][j] = temp.charAt(j);
                }
            }
            int answer = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (box[i][j] == 'o') {
                        if (j - 1 >= 0 && j + 1 < c && box[i][j - 1] == '>'
                            && box[i][j + 1] == '<') {
                            answer++;
                        } else if (i - 1 >= 0 && i + 1 < r && box[i - 1][j] == 'v'
                            && box[i + 1][j] == '^') {
                            answer++;
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}