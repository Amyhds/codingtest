import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] dp = new Set[9];
        // 8번만 사용 가능하므로
        for(int i = 1; i <= 8; i++) {
            dp[i] = new TreeSet<>();
        }
        // 5, 55, 555, ... 추가
        for(int i = 1; i <= 8; i++) {
            dp[i].add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }
        // 1번, 2번, 3번(1과2, 2와1), ... 이렇게 모든 경우의 수
        for(int i = 1; i <= 8; i++) {
            for(int j = 1; j < i; j++) {
                for(int k : dp[j]) {
                    for(int l : dp[i - j]) {
                        dp[i].add(k + l);
                        dp[i].add(k - l);
                        dp[i].add(k * l);
                        if (l != 0) {
                            dp[i].add(k / l);
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= 8; i++) {
            if(dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}