class Solution {
    static int N, answer, target;
    static int[] numbers;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        N = numbers.length;
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int cnt, int sum) {
        if (cnt == N) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(cnt + 1, sum + numbers[cnt]);
        dfs(cnt + 1, sum - numbers[cnt]);
    }
    
    
}