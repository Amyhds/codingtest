import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, group;
	static int[] parents;
	
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
		group--;
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			group = N;
			makeSet();
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(bf.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#" + test_case + " " + group);
		}
		
	}

}
