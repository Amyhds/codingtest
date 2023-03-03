import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	static int N, W, H, min;
	static int[][] map;
	static int[][] copy;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[] seq;
	static boolean isPossible;
		
	private static int getRemains() {  // 남은 벽돌 세기
		int remain = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copy[i][j] != 0) {
					remain++;
				}
			}
		}
		return remain;
	}
	
	private static void moveBlocks() {  // 벽돌 떨어뜨리기
		for (int i = 0; i < W; i++) {  // 한 열씩
			Stack<Integer> stack = new Stack<Integer>();

			for (int j = 0; j < H; j++) {
				if (copy[j][i] != 0) {
					stack.push(copy[j][i]); // 스택에 0이 아닌 값을 넣는다
					copy[j][i] = 0;   // 그 칸 0으로 초기화
				}
			}
			
			int size = stack.size();

			for (int j = H - 1; j >= H - size; j--) { // 스택에 있는 숫자들을 아래부터 채움
				copy[j][i] = stack.pop();
			}
		}
	}

	private static void explode(int X, int Y) {  // 폭발

		Queue<int[]> que = new ArrayDeque<int[]>();
		que.offer(new int[] {X, Y});
		while(!que.isEmpty()) {
			int[] temp = que.poll();
			int x = temp[0];
			int y = temp[1];
			int range = copy[x][y];
			copy[x][y] = 0;
			for (int r = 0; r < range; r++) { // 범위
				for (int d = 0; d < 4; d++) { // 4방향
					int nx = x + dir[d][0] * r;
					int ny = y + dir[d][1] * r;
					if (nx < 0 || nx >= H || ny < 0 || ny >= W)
						continue;						
					if (copy[nx][ny] > 0) {
						que.offer(new int[] {nx, ny});
					}
				}
			}
		}
		moveBlocks();     // 다 폭발했다면 벽돌 떨어뜨리기
	}

	private static void game() {   // 구슬이 떨어질 위치 N개를 받아 게임 진행 
		for (int s = 0; s < N; s++) {
			isPossible = false;
			for (int row = 0; row < H; row++) {
				if (copy[row][seq[s]] != 0) {
					isPossible = true;
					explode(row, seq[s]);
					break;
				}
			}
			if (!isPossible)   // 만약 구슬이 빈 공간에 떨어졌다면 이 경우는 무시
				return;
			if (getRemains() == 0)  // 벽돌이 다 깨졌다면
				return;
		}
	}
	
	private static void init() { // copy 배열 초기화
		copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			copy[i] = map[i].clone();
		}
	}

	private static void makeSeq(int cnt) {
		if (cnt == N) {
			init();
			game();
			if (isPossible) {
				min = Math.min(min, getRemains());
			}
			return;
		}

		for (int i = 0; i < W; i++) {
			seq[cnt] = i;
			makeSeq(cnt + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 받기

			seq = new int[N];
			makeSeq(0); // 가능한 모든 경우 구하기(중복순열)

			System.out.println("#" + test_case + " " + min);
		}
	}

}