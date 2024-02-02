import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {

    static int K, answer;
    static char[] signs;
    static int[] selected;
    static boolean[] visited;
    static HashMap<String, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        signs = new char[K];
        String temp = bf.readLine();
        temp = temp.replaceAll(" ", "");
        for (int i = 0; i < temp.length(); i++) {
            signs[i] = temp.charAt(i);
        }
        selected = new int[K + 1];
        visited = new boolean[10];
        map = new HashMap<>();
        answer = 0;
        combination(0);
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        System.out.println(keySet.get(keySet.size() - 1));
        System.out.println(keySet.get(0));
    }

    public static void combination(int cnt) {
        if (cnt == K + 1) {
            String result = "";
            long num = 0;
            for (int i = 0; i < K + 1; i++) {
                result += selected[i];
            }
            num = Long.valueOf(result);
            if (isValid(result)) {
                map.put(result, num);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            selected[cnt] = i;
            combination(cnt + 1);
            visited[i] = false;
        }
    }

    public static boolean isValid(String result) {
        for (int s = 0; s < K; s++) {
            int left = (int) result.charAt(s);
            int right = (int) result.charAt(s + 1);
            if (signs[s] == '>') {
                if (left < right) {
                    return false;
                }
            } else {
                if (left > right) {
                    return false;
                }
            }
        }
        return true;
    }
}