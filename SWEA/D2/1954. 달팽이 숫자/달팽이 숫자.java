import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	private static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private static int[][] snail;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(bf.readLine());
			snail = new int[N][N];
			// 칸에 들어갈 숫자
			int cnt = 1;
			// x, y는 처음 {0, 1}이 더해지므로 0, -1로 설정했다
			int x = 0;
			int y = -1;
			// 방향 바꾸는 변수
			int d = 0;
			// cnt가 N*N보다 커지면 모든 칸을 다 지나온 것이므로 종료
			while (cnt <= N * N) {
				// 네 방향이 계속 나와야 하므로 d % 4 나머지를 이용
				int nx = x + dir[d % 4][0];
				int ny = y + dir[d % 4][1];
				// 그 칸의 좌표가 범위 내이면서 값이 0일 경우 업데이트한다
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && snail[nx][ny] == 0) {
					// 칸의 값을 cnt로 채우고 후치연산
					snail[nx][ny] = cnt++;
					// 좌표 업데이트
					x = nx;
					y = ny;
				} else {
					// 범위를 벗어나거나 이미 채워진 칸을 갈 경우 방향을 바꿔줌
					d++;
				}
			}
            System.out.println("#" + test_case);
			for (int[] oneLine : snail) {
				for (int one : oneLine) {
					System.out.print(one + " ");
				}
				System.out.println();
			}
		}
	}

}
