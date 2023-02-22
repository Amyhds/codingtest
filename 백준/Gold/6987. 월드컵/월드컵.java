import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] example;
	static int answer;
	static StringBuilder sb;

	static int[] t1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] t2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };

	private static void check(int cnt) {
        
        if(answer == 1) return;
			
		if (cnt == 15) {
			answer = 1;
			return;
		}
		int a = t1[cnt];
		int b = t2[cnt];

		if (example[a][0] > 0 && example[b][2] > 0) {
			example[a][0]--;
			example[b][2]--;
			check(cnt + 1);
			example[a][0]++;
			example[b][2]++;
		}
		if (example[a][1] > 0 && example[b][1] > 0) {
			example[a][1]--;
			example[b][1]--;
			check(cnt + 1);
			example[a][1]++;
			example[b][1]++;
		}
		if (example[a][2] > 0 && example[b][0] > 0) {
			example[a][2]--;
			example[b][0]--;
			check(cnt + 1);
			example[a][2]++;
			example[b][0]++;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int t = 0; t < 4; t++) {
			example = new int[6][3];
			answer = 0;
			int sum = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					sum += example[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (sum == 30)
				check(0);
			sb.append(answer + " ");
		}
		System.out.println(sb.toString());
	}

}
