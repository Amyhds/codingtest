import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());

		Stack<int[]> stk = new Stack<>();

		for (int i = 0; i < N; i++) {
			int building = Integer.parseInt(st.nextToken()); // N개의 탑 높이 받음

			while (!stk.isEmpty()) {
				if (stk.peek()[1] < building) {  // 앞의 탑이 다음 탑보다 작다면
					stk.pop();       // 신호를 받을 수 없으므로 제거
				} else {
					System.out.print(stk.peek()[0] + " "); // 앞의 탑이 크다면 신호를 받으므로 인덱스 출력
					break;
				}
			}
			if (stk.isEmpty()) {
				System.out.print("0 ");    // 탑이 비어있다면 0출력(앞에 신호 받을 탑이 없음)
			}
			stk.push(new int[] { i + 1, building });  // 탑의 순서 번호와 높이 추가
		}
	}
}
// stack의 top 값 (= 이전 탑의 길이) < 현재 탑의 길이일 경우
// 그 탑에 수신할 수 없으므로 stack에 있는 값은 더이상 필요 없기 때문에
// stack의 top 값 (= 이전 탑의 길이) > 현재 탑의 길이가 될 때까지 (= 수신할 수 있는 탑이 나올 때까지)
// 계속 pop 해버린다.
// stack이 empty 상태가 되면
// 수신할 수 있는 탑이 없다는 뜻이므로 0을 출력하고
// 현재 탑의 정보를 저장한다.