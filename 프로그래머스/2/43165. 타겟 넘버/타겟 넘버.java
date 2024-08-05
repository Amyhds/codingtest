class Solution {
    static int[] numbers;
    static int target, answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        recur(0, 0);
        return answer;
    }
    
    public void recur(int cnt, int curr) {
        if (cnt == numbers.length) {
            if (curr == target) {
                answer++;
            }
            return;
        }
        recur(cnt + 1, curr - numbers[cnt]);
        recur(cnt + 1, curr + numbers[cnt]);
    }
}