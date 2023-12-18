import java.io.*;
import java.util.*;

public class Main {

    static Integer[] votes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pos = map.get(color);
            if (pos == null) {
                PriorityQueue<Integer> newPos = new PriorityQueue<>();
                newPos.add(x);
                map.put(color, newPos);
            } else {
                pos.add(x);
                map.put(color, pos);
            }
        }
        for (PriorityQueue<Integer> pos : map.values()
        ) {
            int prev = -1;
            int now = -1;
            int next = -1;
            while (!pos.isEmpty()) {
                if (now == -1) {
                    now = pos.poll();
                    next = pos.peek();
                    answer += next - now;
                } else if (pos.size() == 1) {
                    prev = now;
                    now = pos.poll();
                    answer += now - prev;
                } else {
                    prev = now;
                    now = pos.poll();
                    next = pos.peek();
                    answer += Math.min(now - prev, next - now);
                }
            }
        }
        System.out.println(answer);
    }
}