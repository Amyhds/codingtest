import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] room;
	static int N;
	static List<int[]> res;
	static Queue<int[]> que;

	private static int move(int X, int Y) {

		que = new ArrayDeque<>();
		int cnt = 1;
		que.offer(new int[] { X, Y });

		while (!que.isEmpty()) {
			int[] out = que.poll();
			int x = out[0];
			int y = out[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (room[nx][ny] != room[x][y] + 1)
					continue;
				que.offer(new int[] { nx, ny });
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(bf.readLine());
			room = new int[N][N];
			res = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res.add(new int[] { room[i][j], move(i, j) });
				}
			}

			Collections.sort(res, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o2[1] - o1[1];
				}
			});

			System.out.println("#" + test_case + " " + res.get(0)[0] + " " + res.get(0)[1]);
		}
	}
}
