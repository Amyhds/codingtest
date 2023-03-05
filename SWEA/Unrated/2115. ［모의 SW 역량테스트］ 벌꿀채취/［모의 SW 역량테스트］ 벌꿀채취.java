import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static class Hive {   // M개 연속한 벌통을 하나의 클래스로 만듦
		int sX, sY, eX, eY;
		int[] honey;

		public Hive(int sX, int sY) {
			super();
			this.sX = sX;
			this.sY = sY;
			this.eY = sY + (M - 1);
			makeArr();
		}

		private void makeArr() {
			honey = new int[M];
			for (int y = 0; y < M; y++) {
				honey[y] = beekeeping[sX][y + sY];
			}
		}
	}

	static int N, M, C, res, maxProfit;
	static int[][] beekeeping;
	static List<Hive> hiveList;
	static boolean[] isSelected;
	
	private static int collectHoney(int oneHive, int cnt) {  // 벌통에서 꿀 최대로 채취
		if (cnt == M) {
			int oneHiveC = 0;
			int oneHiveProfit = 0;
			for (int s = 0; s < M; s++) {    // M칸 중 선택한 칸의 꿀을 oneHiveC에 더하고 oneHiveProfit 더해줌
				if (isSelected[s]) {
					oneHiveC += hiveList.get(oneHive).honey[s];
					oneHiveProfit += (hiveList.get(oneHive).honey[s]) * (hiveList.get(oneHive).honey[s]);
				}
			}
			
			if (oneHiveC > C) {      // 선택한 칸의 꿀의 합이 C보다 크면 실패
				return 0;
			} else {              // 크지 않다면
				if (oneHiveProfit > maxProfit)   // 최대 수익보다 크다면 업데이트
					maxProfit = oneHiveProfit;
			}
			return 0;
		}
		
		isSelected[cnt] = true;
		collectHoney(oneHive, cnt + 1);
		isSelected[cnt] = false;
		collectHoney(oneHive, cnt + 1);
		
		return maxProfit;
	}
	
	private static void pickTwoHives() {   // 2명의 일꾼이 겹치지 않게 벌통 선택
		for (int i = 0; i < hiveList.size(); i++) {
			for (int j = 0; j < hiveList.size(); j++) {
				if (hiveList.get(i).sX != hiveList.get(j).sX) {
					int totalProfit = 0;
					totalProfit += collectHoney(i, 0);
					maxProfit = 0;
					totalProfit += collectHoney(j, 0);
					maxProfit = 0;
					res = Math.max(res, totalProfit);
				}
				else if (hiveList.get(i).sX == hiveList.get(j).sX &&
						hiveList.get(i).eY < hiveList.get(j).sY) {
					int totalProfit = 0;
					totalProfit += collectHoney(i, 0);
					maxProfit = 0;
					totalProfit += collectHoney(j, 0);
					maxProfit = 0;
					res = Math.max(res, totalProfit);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			beekeeping = new int[N][N];
			isSelected = new boolean[M];
			maxProfit = 0;
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					beekeeping[i][j] = Integer.parseInt(st.nextToken());   // 양봉장
				}
			}

			hiveList = new ArrayList<Hive>();   // M개 연속한 벌통 저장하는 리스트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					hiveList.add(new Hive(i, j));
				}
			}
			
			pickTwoHives();
			System.out.println("#" + test_case + " " + res);
		}
	}
}