import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Main {

	static int conv;
	static Pos[] posList;
	static boolean[][] isMovable;
	static final int INF = 1001;

	public static int calDist(Pos p1, Pos p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			conv = Integer.parseInt(bf.readLine());
			posList = new Pos[conv + 2];
			isMovable = new boolean[conv + 2][conv + 2];

			for (int i = 0; i < conv + 2; i++) {
				for (int j = 0; j < conv + 2; j++) {
					if (i == j)
						isMovable[i][j] = true;
				}
			}

			StringTokenizer st = new StringTokenizer(bf.readLine());
			posList[0] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i = 1; i <= conv; i++) {
				st = new StringTokenizer(bf.readLine());
				posList[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(bf.readLine());
			posList[conv + 1] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < conv + 2; i++) {
				for (int j = 0; j < conv + 2; j++) {
					if (calDist(posList[i], posList[j]) <= 1000) {
						isMovable[i][j] = true;
						isMovable[j][i] = true;
					}
				}
			}
			
			
			for (int k = 0; k < conv + 2; k++) {
				for (int i = 0; i < conv + 2; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < conv + 2; j++) {
						if (i == j || k == j)
							continue; 
						if (isMovable[i][k] && isMovable[k][j]) {
							isMovable[i][j] = true;
							isMovable[j][i] = true;
						}
					}
				}
			}

			if (isMovable[0][conv + 1] == true)
				System.out.println("happy");
			else
				System.out.println("sad");

		}
	}
}