import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] numbers;
	static int[] accumul;
	
	private static int sumFromTo(int i, int j) {
		
		return accumul[j] - accumul[i-1];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int temp = 0;
		accumul = new int[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			temp += numbers[idx];
			accumul[idx] = temp;
		}
		
		for (int trial = 1; trial <= M; trial++) {
			st = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(sumFromTo(i, j));
		}
	}
}
