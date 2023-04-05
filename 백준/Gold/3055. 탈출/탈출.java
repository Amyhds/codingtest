import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Hog {
	int x, y, time;

	public Hog(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

class Water {
	int x, y, time;
	
	public Water(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Water(int x, int y, int time) {
		this(x, y);
		this.time = time;
	}
}

public class Main {

	static int R, C, res, bX, bY;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static char[][] map;
	static int[][] waterTime;
	static int[][] hogTime;

	private static void bfs2(int hX, int hY) { // 고슴도치의 움직임
		Queue<Hog> que = new ArrayDeque<>();
		que.offer(new Hog(hX, hY, 0));
		hogTime[hX][hY] = 0;
		while (!que.isEmpty()) {
			Hog now = que.poll();
			int x = now.x;
			int y = now.y;
			int time = now.time;
			if (x == bX && y == bY) {
				res = time;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				int ntime = time + 1;
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X')
					continue;
				// 물보다 늦게 도착하거나 이미 지나온 길이면
				if ((waterTime[nx][ny] > 0 && waterTime[nx][ny] <= ntime) || hogTime[nx][ny] != -1)
					continue;
				hogTime[nx][ny] = ntime;
				que.offer(new Hog(nx, ny, ntime));
			}
		}
	}

	private static void bfs1(int wX, int wY) { // 물의 움직임
		Queue<Water> que = new ArrayDeque<>();
		que.offer(new Water(wX, wY, 0));
		waterTime[wX][wY] = 0;
		while (!que.isEmpty()) {
			Water now = que.poll();
			int x = now.x;
			int y = now.y;
			int time = now.time;
			for (int d = 0; d < 4; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				int ntime = time + 1;
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'X')
					continue;
				// 비버굴이거나 이미 다른 물이 먼저 왔다간 경우
				if (map[nx][ny] == 'D' || (waterTime[nx][ny] > 0 && waterTime[nx][ny] <= ntime)) 
					continue;
				waterTime[nx][ny] = ntime;
				que.offer(new Water(nx, ny, ntime));
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		waterTime = new int[R][C];
		hogTime = new int[R][C];

		int hX = 0;
		int hY = 0;
		List<Water> waterLoc = new ArrayList<>();

		for (int row = 0; row < R; row++) {
			String temp = bf.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = temp.charAt(col);
				waterTime[row][col] = -1;
				hogTime[row][col] = -1;
				if (map[row][col] == 'S') {
					hX = row;
					hY = col;
				} else if (map[row][col] == '*') {
					waterLoc.add(new Water(row, col));
				} else if (map[row][col] == 'D') {
					bX = row;
					bY = col;
				}
			}
		}

		for (Water water : waterLoc) {
			bfs1(water.x, water.y); // 물이 차는 시간 기록
		}

//		for (int[] row : waterTime) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println();

		bfs2(hX, hY);

//		for (int[] row : hogTime) {
//			System.out.println(Arrays.toString(row));
//		}

		System.out.println(res == 0 ? "KAKTUS" : res);
	}

}