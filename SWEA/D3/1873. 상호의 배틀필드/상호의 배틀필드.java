import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int H, W, N;
	static char[][] map;
	static int currX, currY;
	static char currDir;

	private static boolean isValid(int x, int y) {
		if (x < 0 || x >= H || y < 0 || y >= W)
			return false;
		if (map[x][y] != '.') 
			return false;
		return true;
	}

	private static void shoot() {
		switch (currDir) {
		case '^':
			for (int i = currX - 1; i > -1; i--) {
				if (map[i][currY] == '#')
					break;
				if (map[i][currY] == '*') {
					map[i][currY] = '.';
					break;
				}
			}
			break;
		case 'v':
			for (int i = currX + 1; i < H; i++) {
				if (map[i][currY] == '#')
					break;
				if (map[i][currY] == '*') {
					map[i][currY] = '.';
					break;
				}
			}
			break;
		case '<':
			for (int i = currY - 1; i > -1; i--) {
				if (map[currX][i] == '#')
					break;
				if (map[currX][i] == '*') {
					map[currX][i] = '.';
					break;
				}
			}
			break;
		case '>':
			for (int i = currY + 1; i < W; i++) {
				if (map[currX][i] == '#')
					break;
				if (map[currX][i] == '*') {
					map[currX][i] = '.';
					break;
				}
			}
			break;
		}
	}

	private static void game(char cmd) {
		switch (cmd) {
		case 'U':
			currDir = '^';
			if (isValid(currX - 1, currY) && map[currX - 1][currY] == '.') {
				map[currX - 1][currY] = currDir;
				map[currX][currY] = '.';
				currX -= 1;
			}
			map[currX][currY] = currDir;
			break;
		case 'D':
			currDir = 'v';
			if (isValid(currX + 1, currY) && map[currX + 1][currY] == '.') {
				map[currX + 1][currY] = currDir;
				map[currX][currY] = '.';
				currX += 1;
			}
			map[currX][currY] = currDir;
			break;
		case 'L':
			currDir = '<';
			if (isValid(currX, currY - 1) && map[currX][currY - 1] == '.') {
				map[currX][currY - 1] = currDir;
				map[currX][currY] = '.';
				currY -= 1;
			}
			map[currX][currY] = currDir;
			break;
		case 'R':
			currDir = '>';
			if (isValid(currX, currY + 1) && map[currX][currY + 1] == '.') {
				map[currX][currY + 1] = currDir;
				map[currX][currY] = '.';
				currY += 1;
			}
			map[currX][currY] = currDir;
			break;
		case 'S':
			shoot();
			break;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				String temp = bf.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = temp.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						currX = i;
						currY = j;
						currDir = map[i][j];
					}
				}
			}
			
			N = Integer.parseInt(bf.readLine());
			String cmd = bf.readLine();

			for (int i = 0; i < N; i++) {
				game(cmd.charAt(i));
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}
