import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int V, E;
	static ArrayList<Vertex>[] adjList;
	static PriorityQueue<Vertex> pq;
	static int[] minEdge;
	static boolean[] visited;
	static int cnt;
    static long res;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			minEdge = new int[V + 1];     // 1부터 시작하므로
			visited = new boolean[V + 1];
			pq = new PriorityQueue<Vertex>();

			adjList = new ArrayList[V + 1];
			for (int i = 0; i <= V; i++) {
				adjList[i] = new ArrayList<>(); // 인접 리스트 할당
				minEdge[i] = Integer.MAX_VALUE; // 최소값 초기화
			}
			// 인접 리스트 초기화
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(bf.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				adjList[from].add(new Vertex(to, weight));
				adjList[to].add(new Vertex(from, weight));
			}

			res = 0; // 최소 가중치
			cnt = 0; // V개 되면 끝
			minEdge[1] = 0; // 1부터 시작
			pq.offer(new Vertex(1, 0)); // (정점 번호, 가중치)

			while (!pq.isEmpty()) {
				Vertex minVertex = pq.poll();
				if (visited[minVertex.no])
					continue;
				visited[minVertex.no] = true;
				res += minVertex.weight;
				if (++cnt == V)
					break;

				for (Vertex newV : adjList[minVertex.no]) { // 인접정점 중
					// 신장트리에 들어가지 않고 가중치가 최소인 정점
					if (!visited[newV.no] && newV.weight < minEdge[newV.no]) { 
						minEdge[newV.no] = newV.weight;
						pq.offer(newV);
					}
				}
			}
			System.out.println("#" + test_case + " " + res);

		}
	}

}
