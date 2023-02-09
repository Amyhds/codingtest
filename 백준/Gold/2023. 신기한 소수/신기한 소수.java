import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb;
	static int N;
	static int[] onePrime = { 1, 2, 3, 5, 7, 9 };
	static boolean[] isSelected;

	private static boolean isPrime(int num) {
		if (num == 1) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
	
	private static void generatePrime(int cnt, int sum) {
	
		if (cnt == N) {
			if (isPrime(sum)) {
				sb.append(sum + "\n");
			}
			return;
		}
		
		if (cnt >= 1 && !isPrime(sum / (int)Math.pow(10, (N - cnt)))) return;
		
		for (int i = 0; i < 6; i++) {
			generatePrime(cnt + 1, sum + onePrime[i] * (int)Math.pow(10, (N - cnt - 1)));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		sb = new StringBuilder();
		generatePrime(0, 0);
		System.out.println(sb.toString());
	}

}
