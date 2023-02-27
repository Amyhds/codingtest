import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] parents;
	static int N, M;
	static StringBuilder sb;

	private static void makeSet() {
		parents = new int[N + 1];
		for (int c = 1; c <= N; c++) {
			parents[c] = c;
		}
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		parents[bRoot] = parents[aRoot];
	}

	private static void isContain(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			sb.append(1);
		else 
			sb.append(0);
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			makeSet(); // 자기자신을 부모로 초기화
			for (int cmd = 0; cmd < M; cmd++) {
				st = new StringTokenizer(bf.readLine());
				int op = Integer.parseInt(st.nextToken()); // 0이면 union, 1이면 find
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0)
					union(a, b);
				else
					isContain(a, b);
			}
			System.out.println("#" + test_case + " " + sb.toString());
		}

	}

}
