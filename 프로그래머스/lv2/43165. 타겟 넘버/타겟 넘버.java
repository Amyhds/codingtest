class Solution {
    static int N;
    static int answer = 0;
    static int target;
    static int[] arr;
    
    public void calculate(int cnt, int total) {
        if (cnt == N) {
            if (total == target) {
                answer++;
            }
            return;
        }
        calculate(cnt + 1, total + arr[cnt]);
        calculate(cnt + 1, total - arr[cnt]);
    }
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        N = numbers.length;
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = numbers[i];
        }
        calculate(0, 0);
        return answer;
    }

}