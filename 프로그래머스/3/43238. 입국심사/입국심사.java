// 백준 2792 보석상자와 동일한 문제!
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 0;
        long end = 0;
        long mid = 0;
        long people = 0;
        for(int i = 0; i < times.length; i++) {
            if (end < times[i]) {
                end = times[i];
            }
        }
        end *= n;
        while(start <= end) {
            people = 0;
            mid = (start + end) / 2;
            for(int i = 0; i < times.length; i++) {
                people += mid / times[i];
            }
            if (people >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}