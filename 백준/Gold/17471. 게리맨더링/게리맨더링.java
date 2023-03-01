import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] popul;
	static ArrayList<Integer>[] adjList;
	static boolean[] isSelected;
	static int min;

	private static boolean isPossible(List<Integer> ward) {

		int check = 1;      // ward의 모든 원소를 방문했는지 확인
		boolean[] visited = new boolean[N + 1];     // 방문 여부 확인
		Queue<Integer> que = new ArrayDeque<Integer>();
		visited[ward.get(0)] = true;   
		que.offer(ward.get(0));

		while (!que.isEmpty()) {
			int curr = que.poll();  
			for (int next : adjList[curr]) {       // curr의 인접리스트에 있는 원소들 중
				if (ward.contains(next) && !visited[next]) { // ward에 포함되고 방문하지 않았다면
					visited[next] = true;   // 방문처리하고
					que.offer(next);   // 큐에 추가
					check++;           // 1개 방문
				}
			}
		}

		if (check == ward.size())
			return true;
		return false;
	}

	private static void getWardPopulDiff() { // 제1, 2선거구의 인구 수 세기
		int ward1Popul = 0;
		int ward2Popul = 0;
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) {
				ward1Popul += popul[i];
			} else {
				ward2Popul += popul[i];
			}
		}
		
		min = Math.min(min, Math.abs(ward1Popul - ward2Popul)); // 최솟값 갱신
	}

	private static void choose(int idx) {
		if (idx == N) { 	// 선거구에 들어갈 구역을 뽑았다면 인구를 구한다
			List<Integer> ward1 = new ArrayList<Integer>(); // 선거구1
			List<Integer> ward2 = new ArrayList<Integer>(); // 선거구2
			for (int i = 1; i <= N; i++) {
				if (isSelected[i]) {
					ward1.add(i);
				} else {           
					ward2.add(i);
				}
			}
			if (ward1.size() == 0 || ward2.size() == 0) // 최소 1구역 이상 있어야 함
				return;
			if (isPossible(ward1) && isPossible(ward2)) // 가능한 경우라면?
				getWardPopulDiff(); // 인구 차이 최솟값 구하기
			return;
		}

		isSelected[idx] = true;
		choose(idx + 1);
		isSelected[idx] = false;
		choose(idx + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		popul = new int[N + 1]; // 인구 저장 배열
		adjList = new ArrayList[N + 1]; // 인접리스트
		isSelected = new boolean[N + 1];
		min = Integer.MAX_VALUE; // 인구 최소값

		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			popul[i] = Integer.parseInt(st.nextToken()); // 인구 입력
		}

		for (int from = 1; from <= N; from++) { // 구역 1부터
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken()); // 인접 구역의 수
			for (int j = 1; j <= M; j++) {
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to); // 인접 리스트에 추가
				adjList[to].add(from);
			}
		}

		choose(0); // 구역 나누기

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

}