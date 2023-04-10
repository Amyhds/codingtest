import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int N = 10;
	static int[] limit = { 0, 5, 5, 5, 5, 5 };
	static int[][] paper;
	static int ans;

	private static boolean isAttachable(int x, int y, int r) {
		for (int i = x; i < x + r; i++) {
			for (int j = y; j < y + r; j++) {
				if (i < 0 || i >= N || j < 0 || j >= N)
					return false;
				if (paper[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	public static void change(int x, int y, int r, int status) {
		for (int i = x; i < x + r; i++) {
			for (int j = y; j < y + r; j++) {
				paper[i][j] = status;
			}
		}
	}

	public static void dfs(int x, int y, int cnt) {
		if (cnt >= ans) 
			return;
		
		if (y > 9) {
			dfs(x + 1, 0, cnt);
			return;
		}

		if (x > 9) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (paper[x][y] == 1) {
			for (int r = 1; r <= 5; r++) {
				if (limit[r] > 0 && isAttachable(x, y, r)) {
					change(x, y, r, 0);
					limit[r]--;
					dfs(x, y + 1, cnt + 1);
					change(x, y, r, 1);
					limit[r]++;
				}
			}
		} else {
			dfs(x, y + 1, cnt);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		paper = new int[N][N];
		ans = 999;
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(bf.readLine());
			for (int col = 0; col < N; col++) {
				paper[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0);
		System.out.println(ans == 999 ? -1 : ans);
	}

}