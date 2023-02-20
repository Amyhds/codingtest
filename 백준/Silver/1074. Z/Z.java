import java.util.Scanner;

public class Main {

	static int N;
	static int r;
	static int c;
	static int len;
	static int cnt;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int cnt = 0;
		int x = 0;
		int y = 0;
		while (N != 0) {
			N -= 1;
			int half = (int) Math.pow(2, N);
			if (r < x + half && c < y + half) {
				cnt += 0;
			} else if (r < x + half && c >= y + half) {
				cnt += half * half;
				y += half;
			} else if (r >= x + half && c < y + half) {
				cnt += half * half * 2;
				x += half;
			} else if (r >= x + half && c >= y + half){
				cnt += half * half * 3;
				x += half;
				y += half;
			}
		}

		System.out.println(cnt);
	}

}
