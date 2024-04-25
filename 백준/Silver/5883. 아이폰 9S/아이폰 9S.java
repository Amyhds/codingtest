import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class Main {

    static int N;
    static List<Integer> line;
    static Set<Integer> set;
    static List<Integer> setList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        line = new ArrayList<>();
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int phone = Integer.parseInt(bf.readLine());
            line.add(phone);
            set.add(phone);
        }
        setList = new ArrayList<>(set);
        int answer = 0;
        for (int out : setList) {
            answer = Math.max(answer, getLength(out));
        }
        System.out.println(answer);
    }

    public static int getLength(Integer out) {
        List<Integer> tempList = new ArrayList<>(line);
        tempList.removeIf(num -> Objects.equals(num, out));
//        for (int num : tempList) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
        int max = 1;
        int length = 1;
        for (int i = 1; i < tempList.size(); i++) {
            int prev = tempList.get(i - 1);
            int curr = tempList.get(i);
            if (prev == curr) {
                length++;
                max = Math.max(max, length);
            } else {
                length = 1;
            }
        }
        return max;
    }
}