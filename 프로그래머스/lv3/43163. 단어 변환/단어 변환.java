import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> visited = new HashMap<>(); // 방문 횟수? 단계 기록
        int N = words.length;
        int M = words[0].length();
        for(String word : words) {
            if(word.equals(begin)) { // 집합에 begin과 똑같은 단어가 있다면 pass
                continue;
            }
            map.put(word, word);
            System.out.println(word);
            visited.put(word, 0);
        }
        visited.put(begin, 0); // 시작단어는 일단 0으로
        if (!map.containsKey(target)) {  // 타겟 단어가 있는지 미리 확인
            return answer;
        }
        
        Queue<String> que = new ArrayDeque<>();
        que.offer(begin);
        while(!que.isEmpty()) {
            String curr = que.poll();
            for(String word : words) {
                int diff = 0;
                if (visited.get(word) > 0) {
                        continue;
                    }
                for (int w = 0; w < M; w++) {
                    
                    if (word.charAt(w) != curr.charAt(w)) {
                        diff++;
                    }
                }              
                if (diff == 1) { // 1글자만 다른 경우
                    if (word.equals(target)) {
                        return visited.get(curr) + 1;
                    }
                    que.offer(word);
                    visited.put(word, visited.get(curr) + 1);
                    answer = visited.get(word);
                } 
            }
        }
        if (visited.get(target) == 0) {
            return 0;
        }
        return answer;
    }
}