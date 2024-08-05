class Solution {
    static int[][] triangle;
    static int answer, len;
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        answer = 0;
        this.triangle = triangle;
        len = triangle.length;
        dp = new int[len + 1][len + 1];
        answer = recur(0, 0);
        return answer;
    }
    
    public int recur(int x, int y) {
        if (x == len) {
            return 0;
        }
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        dp[x][y] = Math.max(recur(x + 1, y) + triangle[x][y], recur(x + 1, y + 1) + triangle[x][y]);
        return dp[x][y];
    }
    
    
}