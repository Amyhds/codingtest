class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        int[] allStudents = new int[n];
        
        for(int l : lost) {
            allStudents[l - 1]--;
        }
        
        for(int r : reserve) {
            allStudents[r - 1]++;
        }
        
        for(int i = 0; i < n - 1; i++) {
            if ((allStudents[i] + allStudents[i+1] == 0) && (allStudents[i] != 0)) {
                allStudents[i] = 0;
                allStudents[i + 1] = 0;
            }
        }
        
        for(int a : allStudents) {
            if (a == -1) {
                answer--;
            }
        }
        
        return answer;
    }
}