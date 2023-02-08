import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[][] arr;
	private static int[][] accumul;
	private static StringBuilder sb;
	
	private static int sum(int x1, int y1, int x2, int y2) {
		
		int res = 0;
		for (int i = x1; i <= x2; i++) {
			res += accumul[i][y2] - accumul[i][y1 - 1];
		}
		return res;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//
		arr = new int[N][N];
		// 누적합 배열
		accumul = new int[N + 1][N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 누적합 배열 초기화
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				temp += arr[i][j];
				accumul[i + 1][j + 1] = temp;
			}
		}
		// 열만 1개 늘려줬으므로 x값에서만 -1 해준다
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(sum(x1, y1, x2, y2) + "\n");
		}
		System.out.println(sb.toString());

	}

}
