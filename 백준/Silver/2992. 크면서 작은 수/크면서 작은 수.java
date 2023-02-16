import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int len;

	private static void swap(int[] input, int x, int y) {
		int temp = input[x];
		input[x] = input[y];
		input[y] = temp;
	}

	private static int np(int[] input) {

		int n = input.length;

		// step1. 뒤쪽부터 꼭대기를 찾는다(꼭대기 바로 앞이 교환할 자리)
		int i = n - 1;
		// i가 0까지 가거나 꼭대기에서 떨어졌을 때 빠져나온다
		while (i > 0 && input[i - 1] >= input[i])
			--i;
		if (i == 0)       // 이미 가장 큰 순열일 때
			return 0;

		// step2. 꼭대기 바로 앞(i-1) 자리에 교환할 값을 뒤쪽부터 찾는다
		int j = n - 1;
		// 끝에서부터 j가 오면서 큰 수들 중 작은 수를 찾는다
		// j는 쭉 오면서 i까지 올 수 있다
		while (input[i - 1] >= input[j])
			--j;

		// step3. 꼭대기 바로 앞(i-1)자리와 그 자리값보다 한단계 큰 자리(j) 수와 교환
		swap(input, i - 1, j);
		
		//step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k = n - 1;
		while(i < k) {
			swap(input, i++, k--);
		}

		String res = "";
		for (int idx = 0; idx < len; idx++) {
			res += input[idx];
		}
		return Integer.parseInt(res);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String X = sc.next();
		len = X.length();
		int[] input = new int[len];
		
		for (int i = 0; i < len; i++) {
			input[i] = Character.getNumericValue(X.charAt(i));
		}

		System.out.println(np(input));
	}
}
