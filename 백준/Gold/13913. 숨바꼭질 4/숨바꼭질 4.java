import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static final int MAX = 100001;
	static int[] location, parent;
	static boolean[] visited;
	static int N, K;
	static StringBuilder sb;

	private static void printTrace() {
		Stack<Integer> stack = new Stack<Integer>();
		int last = K;
		while (last != N) {
			stack.push(last);
			last = parent[last];
		}
		stack.push(last);
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
	}

	private static boolean isValid(int loc) {
		if (loc < 0 || loc > 100000)
			return false;
		return true;
	}

	private static void find() {

		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(N);
		int curr = 0;
		int time = 0;
		int size = 0;
		while (!que.isEmpty()) {
			size = que.size();
			for (int i = 0; i < size; i++) {
				curr = que.poll();
				location[curr] = time;
				if (curr == K)
					return;
				if (isValid(curr - 1) && !visited[curr - 1]) {
					que.offer(curr - 1);
					visited[curr - 1] = true;
					parent[curr - 1] = curr;
				}
				if (isValid(curr + 1) && !visited[curr + 1]) {
					que.offer(curr + 1);
					visited[curr + 1] = true;
					parent[curr + 1] = curr;
				}
				if (isValid(curr * 2) && !visited[curr * 2]) {
					que.offer(curr * 2);
					visited[curr * 2] = true;
					parent[curr * 2] = curr;
				}
			}
			time++;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		location = new int[MAX];
		parent = new int[MAX];
		visited = new boolean[MAX];
		sb = new StringBuilder();

		find();
		System.out.println(location[K]);
		printTrace();
		System.out.println(sb.toString());
	}

}