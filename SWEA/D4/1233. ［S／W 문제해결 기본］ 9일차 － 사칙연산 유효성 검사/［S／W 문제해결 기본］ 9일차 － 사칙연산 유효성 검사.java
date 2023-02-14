import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 1;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				st.nextToken();										  // 인덱스(노드 번호)
				if (i < N / 2) {                                      // 리프노드가 아닌 경우
					if (Character.isDigit(st.nextToken().charAt(0)))  // 숫자가 온다면 틀린 연산
						answer = 0;
				} else {                                              // 리프노드인 경우
					if (!Character.isDigit(st.nextToken().charAt(0))) // 연산자가 온다면 틀린 연산
						answer = 0;
				}
				while (st.hasMoreTokens()) {                  // 리프노드 입력이 아니면 자식노드 번호도 오므로 받아준다
					st.nextToken();
				}
			}

			System.out.println("#" + test_case + " " + answer);
		}

	}

}