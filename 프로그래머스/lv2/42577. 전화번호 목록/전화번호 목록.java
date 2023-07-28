import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
//         boolean answer = true;
        
//         HashMap<String, String> hm = new HashMap<>();
//         for(String num : phone_book) {
//             hm.put(num, num);
//         }
        
//         int N = phone_book.length;
        
//         for(int i = 0; i < N - 1; i++) {
//             for(int j = i + 1; j < N; j++) {
//                 hm.get()
//             }
//         }
        
//         return answer;
        
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++){        
            if (phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}