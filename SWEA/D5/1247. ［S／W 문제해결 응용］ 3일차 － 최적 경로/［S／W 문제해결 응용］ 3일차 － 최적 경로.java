import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static Pos samsung;
	static Pos home;
	static Pos[] customer;
	static boolean[] visited;
	static int min;

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static void dfs(int curr, int cnt, int path) {

		if (cnt == N - 1) {
			min = Math.min(min, path + Math.abs(customer[curr].x - home.x) + Math.abs(customer[curr].y - home.y));
			return;
		}

		for (int next = 0; next < N; next++) {
			if (visited[next])
				continue;
			visited[next] = true;
			dfs(next, cnt + 1, path + Math.abs(customer[curr].x - customer[next].x)
					+ Math.abs(customer[curr].y - customer[next].y));
			visited[next] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			samsung = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customer = new Pos[N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				customer[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			for (int start = 0; start < N; start++) {
				visited[start] = true;
				dfs(start, 0, Math.abs(customer[start].x - samsung.x) + Math.abs(customer[start].y - samsung.y));
				visited[start] = false;
			}

			System.out.println("#" + test_case + " " + min);
		}
	}

}