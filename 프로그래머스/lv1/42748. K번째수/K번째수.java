import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int N = commands.length;
        answer = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int order = command[2];
            int[] newArr = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(newArr);
            list.add(newArr[order - 1]);
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}