import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Time implements Comparable<Time>{
	int s;
	int t;
	
	Time(int s, int t) {
		this.s = s;
		this.t = t;
	}

	@Override
	public int compareTo(Time o) {
		if (this.s == o.s) {
			return this.t - o.t;
		}
		return this.s - o.s;
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Time[] arr = new Time[N];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[i] = new Time(s, t);
		}
		
		Arrays.sort(arr);
		pq.offer(arr[0].t);
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= arr[i].s) {
				pq.poll();
			}
			pq.offer(arr[i].t);
		}
		
		System.out.println(pq.size());
	}

}
