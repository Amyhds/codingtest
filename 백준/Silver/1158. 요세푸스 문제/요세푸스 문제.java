import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		LinkedList<Integer> lst = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			lst.add(i);           // 1-N명 입력받음
		}

		int idx = 0;
		while (!lst.isEmpty()) {
			idx += K - 1;      // 2번 인덱스가 3번째 값이므로
			if (idx >= lst.size()) {
				idx = idx % lst.size();     // idx가 size를 넘어가면 idx를 size로 나눈 나머지로
			}
			res.add(lst.remove(idx));     // remove한 값을 결과리스트에 추가
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int i = 0; i < N - 1; i++) {
			sb.append(res.get(i) + ", ");
		}
		sb.append(res.get(N - 1)).append(">");
		System.out.println(sb.toString());

	}

}
