class Solution {
    
    static boolean[] visited;
    static int[] seq;
    static int size, k, answer;
    static int[][] dung;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        size = dungeons.length;
        dung = dungeons;
        this.k = k;
        visited = new boolean[size];
        seq = new int[size];
        perm(0);
        return answer;
    }
    
    public void perm(int cnt) {
        if (cnt == size) {
            answer = Math.max(answer, check());
            return;
        }
        for(int i = 0; i < size; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq[cnt] = i;
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public int check() {
        int result = 0;
        int remain = k;
        for (int i = 0; i < size; i++) {
            if (remain >= dung[seq[i]][0]) {
                result++;
                remain -= dung[seq[i]][1];
            }
        }
        return result;
    }
}