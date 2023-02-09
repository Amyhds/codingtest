import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] food;
	static int N;
	static int minDiff;
	static boolean[] isSelected;

	private static int checkDiff() {
		int sour = 1;
		int bitter = 0;
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) {    // 선택된 재료들 
				sour = sour * food[i][0];   // 신맛은 곱해주고
				bitter += food[i][1];   // 쓴맛은 더해준다
			}
		}
		return Math.abs(sour - bitter); // 차이 반환
	}
	
	private static void cook(int cnt, int notZero) {
		if (cnt == N) {  // 모든 재료를 다 쓰면
			if (notZero >= 1 ) {
				int tempDiff = checkDiff();  // 신맛과 쓴맛의 차이 구하기
				minDiff = Math.min(minDiff, tempDiff);  // 최소값으로 갱신
			}
			return;
		}
		// 재료 선택 
		isSelected[cnt] = true;
		cook(cnt + 1, notZero + 1);
		// 재료 선택하지 않음
		isSelected[cnt] = false;
		cook(cnt + 1, notZero);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); // N 입력
		food = new int[N][2]; // 재료 저장 배열 할당
		isSelected = new boolean[N]; // 선택 여부 배열 할당
		minDiff = Integer.MAX_VALUE; // 최소 차이 변수를 제일 큰 수로 설정
		// 입력 받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			food[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		// 요리 시작
		cook(0, 0);
		// 출력
		System.out.println(minDiff);
	}

}
