import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] adjList;
	static int N;
	static int answer = 0;
	static boolean[] visited;
	
	private static void dfs(int cnt, int curr) {

		if(cnt == 4) {
			answer = 1;
			return;
		}

		visited[curr] = true;
		
		for (int vertex : adjList[curr]) { 
			if (!visited[vertex]) {
				dfs(cnt + 1, vertex);
				visited[vertex] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];		
		
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[A].add(B);
			adjList[B].add(A);
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			if (adjList[i].isEmpty()) continue;
			dfs(0, i);
			if (answer == 1) break;
		}
		
		System.out.println(answer);
	}
}