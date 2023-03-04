import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static ArrayList<int[]> home;
    static ArrayList<int[]> chicken;
	static boolean[] isSelected;
	static int min;
	
	private static void getDist() {
		int cDist = 0;
		for (int h = 0; h < home.size(); h++) {    // 모든 집을 돌면서(집이 기준)
			int hDist = Integer.MAX_VALUE;  // 치킨 거리는 최소여야 하므로
			for (int c = 0; c < chicken.size(); c++) {    // 선택된 치킨집과의 치킨 거리 구하기
				if (isSelected[c]) {
					int temp = Math.abs(home.get(h)[0] - chicken.get(c)[0]) + 
							Math.abs(home.get(h)[1] - chicken.get(c)[1]);
					hDist = Math.min(hDist, temp);
				}
			}
			cDist += hDist;
		}
		min = Math.min(min, cDist);
	}
	
	private static void comb(int start, int cnt) {
		if (cnt == M) {
			getDist();
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			isSelected[i] = true;
			comb(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 입력 및 할당
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		home = new ArrayList<>(); // 집 위치 담는 배열
		chicken = new ArrayList<>();  // 치킨집 위치 담는 배열
		
		min = Integer.MAX_VALUE;  // 치킨거리 최소값
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				}
				if (map[i][j] == 1) {
					home.add(new int[] { i, j });
				}
			}
		}
		
		isSelected = new boolean[chicken.size()];
		comb(0, 0);
		System.out.println(min);
	}
}