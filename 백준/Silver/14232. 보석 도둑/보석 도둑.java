import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(bf.readLine());
        int count = 0;
        List<Long> jewels = new ArrayList<>();
        for (long i = 2; i <= Math.sqrt(K); i++) {
            while (K % i == 0) {
                jewels.add(i);
                count++;
                K /= i;
            }
        }
        if (K != 1) {
            jewels.add(K);
            count++;
        }
        System.out.println(count);
        for (long jewel : jewels
        ) {
            System.out.print(jewel);
            System.out.print(" ");
        }
    }

}