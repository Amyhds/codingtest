import java.util.*;
class Solution {    
    public int solution(int N, int number) {
        int answer = -1;
        if (N == number) {
            return 1;
        }
        int[] nList = new int[9];
        Set<Integer>[] dp = new Set[9];
        
        for(int i = 1; i <= 8; i++) {
            nList[i] = nList[i - 1] + N * (int)Math.pow(10, i - 1);
            dp[i] = new TreeSet();
            dp[i].add(nList[i]);
        }
        for(int count = 1; count <= 8; count++) {
            for(int prev = 1; prev < count; prev++) {
                for(int first: dp[prev]) {
                    for(int second:dp[count - prev]) {
                        dp[count].add(first + second);
                        dp[count].add(first - second);
                        dp[count].add(first * second);
                        if (second != 0) {
                            dp[count].add(first / second);
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= 8; i++) {
            if (dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}