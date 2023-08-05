import java.util.*;

class Solution {
 
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> que = new ArrayDeque<>();
        int N = progresses.length;
        int[] days = new int[N];

        for(int i = 0; i < N; i++) {
            days[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days[i]++;
            }
            que.offer(days[i]);
        }
        
        while(!que.isEmpty()) {
            int cnt = 0;
            int first = que.poll();
            cnt++;
            while (!que.isEmpty() && first >= que.peek()) {
                que.poll();
                cnt++;
            }
            answerList.add(cnt);
        }
        
        int len = answerList.size();
        int[] answer = new int[len];

        for(int l = 0; l < len; l++) {
            answer[l] = answerList.get(l);
        }
        
        return answer;
    }
}