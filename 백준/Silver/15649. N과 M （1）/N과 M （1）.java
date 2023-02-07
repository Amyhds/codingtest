import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	private static boolean[] isSelected;
	private static int[] numbers;
	private static StringBuilder sb;
	
	private static void comb(int cnt) {
		if (cnt == M) {
			sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			System.out.println(sb.toString());
			return;
		}
		for (int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			comb(cnt + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		isSelected = new boolean[N + 1];
		comb(0);
	}

}
