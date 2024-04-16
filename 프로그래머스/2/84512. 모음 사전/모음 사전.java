import java.util.*;
class Solution {
    static List<String> list;
    static String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        list = new ArrayList<>();
        StringBuilder sb = null;
        for(int cnt = 1; cnt <= 5; cnt++) {
            sb = new StringBuilder();
            perm(0, cnt, sb);
        }
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }
    
    public void perm(int check, int finalCount, StringBuilder sb) {
        if (check == finalCount) {
            list.add(sb.toString());
            return;
        }
        for(int i = 0; i < 5; i++) {
            sb.append(vowels[i]);
            perm(check + 1, finalCount, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}