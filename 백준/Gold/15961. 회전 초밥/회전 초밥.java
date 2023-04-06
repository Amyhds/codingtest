import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, d, k, c, max;
	static int[] belt, kind;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 나올 수 있는 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		max = 0;
		belt = new int[N + k - 1]; // 벨트 위 초밥 저장(회전까지 고려해서 늘렸다)
		kind = new int[d + 1]; // 30가지이면 kind[30]까지 만들어야 하므로

		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(bf.readLine());
		}
		for (int i = 0; i < k - 1; i++) {
			belt[N + i] = belt[i];
		}

		int cnt = 0; // k개씩 뽑을 때의 가짓수
		for (int j = 0; j < k; j++) { // 처음 k만
			int sushi = belt[j];
			if (kind[sushi] == 0) {
				cnt++;
			}
			kind[sushi]++;
		}
		if (kind[c] == 0) {
			cnt++;
		}
		kind[c]++;
		max = Math.max(max, cnt); // 최대값 갱신

//		System.out.println(Arrays.toString(kind));
//		System.out.println(max);

		for (int i = 1; i < N; i++) {
			int prev = belt[i - 1];
			if (kind[prev] == 1) {
				cnt--;
			}
			kind[prev]--;
			int next = belt[i + k - 1];
			if (kind[next] == 0) {
				cnt++;
			}
			kind[next]++;
			if (kind[c] == 0) {
				cnt++;
			}
			kind[c]++;
			max = Math.max(max, cnt);
//			System.out.println(Arrays.toString(kind));
//			System.out.println(max);
		}

		System.out.println(max);
	}

}