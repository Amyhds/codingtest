import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static class BC {
		int x, y, cover, perf;

		public BC(int x, int y, int cover, int perf) {
			super();
			this.x = x;
			this.y = y;
			this.cover = cover;
			this.perf = perf;
		}

	}

	static int M, A;
	static int[] trackA;
	static int[] trackB;
	static BC[] charger;
	static int[] userA;
	static int[] userB;
	static int res;
	static int[][] dir = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	private static int check(BC bc, int[] user) {
		return Math.abs(bc.x - user[0]) + Math.abs(bc.y - user[1]) <= bc.cover ? bc.perf : 0;
	}
	
	private static int charge() {
		int max = 0;
		for (int a = 0; a < A; a++) {
			for (int b = 0; b < A; b++) {
				int sum = 0;
				int sumA = check(charger[a], userA);
				int sumB = check(charger[b], userB);
				if (a != b) {
					sum = sumA + sumB;
				} else {
					sum = sumB;
				}
				max = Math.max(sum, max);
			}
		}
		return max;
		
	}
	
	private static void findCharger() {
		for (int i = 0; i < M + 1; i++) {
			userA[0] += dir[trackA[i]][0];
			userA[1] += dir[trackA[i]][1];
			userB[0] += dir[trackB[i]][0];
			userB[1] += dir[trackB[i]][1];
			
			res += charge();
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			trackA = new int[M + 1];
			trackA[0] = 0;
			trackB = new int[M + 1];
			trackB[0] = 0;
			charger = new BC[A];
			userA = new int[] { 1, 1 };
			userB = new int[] { 10, 10 };
			res = 0;
			st = new StringTokenizer(bf.readLine());
			for (int move = 1; move <= M; move++) {
				trackA[move] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for (int move = 1; move <= M; move++) {
				trackB[move] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(bf.readLine());
				charger[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			findCharger();
			System.out.println("#" + test_case + " " + res);
		}

	}

}
