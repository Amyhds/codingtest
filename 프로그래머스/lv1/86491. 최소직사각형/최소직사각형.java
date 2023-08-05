import java.util.*;

class Solution {
    public int solution(int[][] sizes) {

        int n = sizes.length;
        int[] hrz = new int[n];
        int[] vtc = new int[n];
        for(int i = 0; i < n; i++) {
            hrz[i] = Math.max(sizes[i][0], sizes[i][1]);
            vtc[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        int h = 0;
        int v = 0;
        for(int i = 0; i < n; i++) {
            h = Math.max(h, hrz[i]);
            v = Math.max(v, vtc[i]);
        }
           
        return h * v;
    }
}