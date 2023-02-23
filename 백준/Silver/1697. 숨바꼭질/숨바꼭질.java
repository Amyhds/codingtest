import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] location;
	static int N, K;
	
	private static boolean isValid(int loc) {
		if (loc < 0 || loc > 100000) return false;
		if (location[loc] != 0) return false;
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
				if (curr == K) return;
				if (isValid(curr - 1))	que.offer(curr - 1);
				if (isValid(curr + 1))	que.offer(curr + 1);
				if (isValid(curr * 2))	que.offer(curr * 2);
			}
			time++;
		}

	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		location = new int[100001];
		find();
		System.out.println(location[K]);
	}

}
