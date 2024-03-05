import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt;
    static int[][] room;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cleanHere(r, c, d);
        System.out.println(cnt);
    }

    public static void cleanHere(int r, int c, int d) {
        if (room[r][c] == 0) {
            room[r][c] = -1; // 현재 칸 청소
            cnt++;
        }
        for (int i = 0; i < 4; i++) { // 주변 4칸 검사
            d = (d + 3) % 4; // 반시계 90도 회전
            int nr = r + dir[d][0]; // 회전한 상태에서 앞칸 좌표 구하기
            int nc = c + dir[d][1];
            if (room[nr][nc] == 0) { // 청소하지 않은 빈 칸인 경우
                cleanHere(nr, nc, d);
                return;
            }
        }
        // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        int nd = (d + 2) % 4;
        int nr = r + dir[nd][0]; // 1칸 후진
        int nc = c + dir[nd][1];
        if (room[nr][nc] != 1) { // 후진할 수 있다면 1번으로 돌아감
            cleanHere(nr, nc, d);
        }
    }

}