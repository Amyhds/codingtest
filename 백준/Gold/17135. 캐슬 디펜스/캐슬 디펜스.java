import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] board;
	static int N, M, D;
	static int res;
	static Queue<int[]> que;

	private static void choose(int start, int cnt, int[] archer) {
		if (cnt == 3) {
			res = Math.max(res, attack(archer));
			return;
		}
		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			choose(i + 1, cnt + 1, archer);
		}
	}

	private static int attack(int[] archer) {

		boolean[][] battle = new boolean[N + 1][M]; // clone 하면 2차원이라 배열들은 이전 조합 상태 그대로임..
		for (int i = 0; i < N + 1; i++) { // 반복문 + ArrayCopy
			System.arraycopy(board[i], 0, battle[i], 0, M);
		}
		int attackCnt = 0;

		for (int battleCnt = 1; battleCnt <= N; battleCnt++) { // 모든 적이 격자판에서 제외될 때까지
			que = new ArrayDeque<int[]>();  // 공격할 적을 저장하는 큐
			for (int a = 0; a < 3; a++) { // 궁수 별로 공격 가능한 위치 찾기
				battle[N][archer[a]] = true; // 궁수 배치
				int min = Integer.MAX_VALUE;
				int[] updateEnemy = new int[2];  // 현재 궁수의 가장 가까운 적의 위치
				for (int enemC = 0; enemC < M; enemC++) { // 왼쪽부터 탐색
					for (int enemR = N - 1; enemR >= 0; enemR--) { // 궁수 위치하는 행 바로 위부터 적 탐색
						int dist = Math.abs(N - enemR) + Math.abs(archer[a] - enemC);  // 제일 가까운 거리 찾기
						if (battle[enemR][enemC] && dist <= D) { // 공격
							if (dist < min) {  // 더 가까이 있는 적 고르기
								min = dist;
								updateEnemy[0] = enemR;
								updateEnemy[1] = enemC;
								break;        
							}
						}
					}
				}
				if(min != Integer.MAX_VALUE)
					que.offer(new int[] { updateEnemy[0], updateEnemy[1] }); // 큐의 공격 가능한 적의 위치 넣기
			}

			while (!que.isEmpty()) {
				int[] enemy = que.poll();
				int enemR = enemy[0];
				int enemC = enemy[1];
				if (battle[enemR][enemC]) { // 이미 제거된 적이라면 pass
					battle[enemR][enemC] = false; // 적 제거
					attackCnt++;
				}
			}
			
			
            for (int i = N - 1; i >= 1; i--) { // 한줄씩 내려온다
                battle[i] = battle[i - 1];
            }
            battle[0] = new boolean[M];     // 맨 윗줄은 0(false)으로 채워진 배열로 
		}

		return attackCnt;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		board = new boolean[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					board[i][j] = true;
				}
			}
		}

		choose(0, 0, new int[3]);
		System.out.println(res);
	}

}