import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(bf.readLine());
        int w1 = 2;
        int w2 = 1;
        int end = 50001;
        List<Integer> results = new ArrayList<>();
        while (w1 > w2 && w1 < end) {
            long diff = (long) w1 * w1 - (long) w2 * w2;
            if (diff < G) {
                w1++;
            } else if (diff > G) {
                w2++;
            } else {
                results.add(w1);
                w2++;
            }
        }
        if (results.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(results);
            for (int result : results
            ) {
                System.out.println(result);
            }
        }
    }
}