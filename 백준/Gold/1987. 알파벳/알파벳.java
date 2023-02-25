import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int R, C, max;
	static char[][] board;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static Stack<Character> stack;
	static Set<Character> set;

	private static void dfs(int x, int y) {

		set.add(board[x][y]);
		max = Math.max(max, set.size());

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;
			if (set.contains(board[nx][ny]))
				continue;
			dfs(nx, ny);
			set.remove(board[nx][ny]);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		stack = new Stack<Character>();
		set = new HashSet<Character>();
		for (int r = 0; r < R; r++) {
			String temp = bf.readLine();
			for (int c = 0; c < C; c++) {
				board[r][c] = temp.charAt(c);
			}
		}

		max = 1;
		dfs(0, 0);
		System.out.println(max);
	}

}