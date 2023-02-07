import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int std;
	private static Boolean[] switches;

	// 남학생
	private static void boy(int num) {
		for (int i = 1; i <= N; i++) {
			// 배수가 아니면 넘기기
			if (i % num != 0)
				continue;
			switches[i] = !switches[i];
		}
	}

	// 여학생
	private static void girl(int num) {
		int len = Math.min(N - num, num - 1);
		// 대칭 왼쪽 끝의 인덱스를 저장할 변수
		int left = num;
		// 대칭 오른쪽 끝의 인덱스를 저장할 변수
		int right = num;
		for (int l = 1; l <= len; l++) {
			// 대칭이 아니라면 break;
			if (switches[num - l] != switches[num + l]) break;
			left--;
			right++;
		}
		// 대칭구간 스위치 상태 바꾸기
		for (int i = left; i <= right; i++) {
			switches[i] = !switches[i];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 스위치 개수
		N = Integer.parseInt(bf.readLine());
		// 스위치 상태
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 인덱스 1부터 쓰기 위해 N+1개의 크기로 생성
		switches = new Boolean[N + 1];
		// 1이면 true, 0이면 false
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == 0) {
				switches[i] = false;
			} else {
				switches[i] = true;
			}
		}
		// 학생 수
		std = Integer.parseInt(bf.readLine());
		for (int i = 1; i <= std; i++) {
			st = new StringTokenizer(bf.readLine());
			// 학생 성별
			int gender = Integer.parseInt(st.nextToken());
			// 학생이 받은 수
			int num = Integer.parseInt(st.nextToken());
			// 성별 나눠서 진행
			if (gender == 1)
				boy(num);
			else
				girl(num);
		}
		// 출력
		for (int i = 1; i <= N; i++) {
			if (switches[i]) System.out.print(1 + " ");
			else System.out.print(0 + " ");
			if (i % 20 == 0) 
				System.out.println();
		}
	}

}
