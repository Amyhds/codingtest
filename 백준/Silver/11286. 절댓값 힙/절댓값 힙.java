import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class AbsNum {

	int absol;
	int origin;

	public AbsNum(int absol, int origin) {
		this.absol = absol;
		this.origin = origin;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		PriorityQueue<AbsNum> pq = new PriorityQueue<>(new Comparator<AbsNum>() {

			@Override
			public int compare(AbsNum o1, AbsNum o2) {
				if (o1.absol == o2.absol) {
					return o1.origin - o2.origin;
				}
				return o1.absol - o2.absol;
			}
		
			
		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(bf.readLine());
			if (x == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
					continue;
				}
				AbsNum res = pq.poll();
				System.out.println(res.origin);
			} else {
				pq.offer(new AbsNum(Math.abs(x), x));
			}
		}

	}

}