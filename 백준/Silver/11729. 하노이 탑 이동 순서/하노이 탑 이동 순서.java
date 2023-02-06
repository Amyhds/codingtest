import java.util.Scanner;
 
public class Main {
 
	public static StringBuilder sb = new StringBuilder(); 
 
	public static void hanoi(int N, int start, int mid, int dest) {
		if (N == 1) {
			sb.append(start + " " + dest + "\n");
			return;
		}
        // N - 1개를 1에서 2로 이동
        // 가장 큰 판을 제외한 나머지의 이동
		hanoi(N - 1, start, dest, mid);
        // 1개를 1에서 3으로 이동
        // 가장 큰 판의 목적지 이동
		sb.append(start + " " + dest + "\n");
        // N - 1개를 2에서 3으로 이동
        // 목적지로 이동한 가장 큰 판 위로 나머지 판들의 이동
		hanoi(N - 1, mid, start, dest);
 
	}

	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 이동 횟수
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');
        // 탑 옮기기 시작
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
 
	}
}