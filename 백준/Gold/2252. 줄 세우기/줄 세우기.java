import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] inDegree;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Integer> result;

	private static void topSort() {

		Queue<Integer> que = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				que.offer(i);
			}
		}

		while (!que.isEmpty()) {
			int curr = que.poll();
			result.add(curr);
			for (int shorter : adjList[curr]) {
				if (--inDegree[shorter] == 0) {
					que.offer(shorter);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new ArrayList<>();
		adjList = new ArrayList[N + 1];
		inDegree = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			inDegree[to]++;
		}

		topSort();

		for (int student : result) {
			System.out.print(student + " ");
		}

	}

}