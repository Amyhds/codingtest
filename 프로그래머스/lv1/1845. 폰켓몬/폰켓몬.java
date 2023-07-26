import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length / 2;
        
        HashMap<Integer, Integer> hm = new HashMap();
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        if (hm.size() >= N) {
            answer = N;
        } else {
            answer = hm.size();
        }
        
        return answer;
    }
}