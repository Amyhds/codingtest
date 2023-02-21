import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static int R, C;
	static int cnt;
	static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	
	private static boolean dfs(int x, int y) {
		
		map[x][y] = 'x';    // 다시 방문 못하도록
		
		if (y == C - 1) { // 끝까지 갔다면 true 리턴
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
			if(map[nx][ny] == 'x') continue;
			if(dfs(nx, ny)) return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		cnt = 0;
		
		for (int i = 0; i < R; i++) {
			String temp = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			if(dfs(i, 0)) cnt++;
		}

		System.out.println(cnt);
	}

}