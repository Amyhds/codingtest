import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int x, n;
    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            x = (int) (sc.nextInt() * Math.pow(10, 7));
            n = sc.nextInt();
            arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            int start = 0;
            int end = n - 1;
            int lego1 = -1;
            int lego2 = -1;

            while(start < end) {
                if (arr[start] + arr[end] < x) {
                    start++;
                } else if (arr[start] + arr[end] > x) {
                    end--;
                } else {
                    if (lego1 == -1 && lego2 == -1) {
                        lego1 = arr[start];
                        lego2 = arr[end];
                    } else {
                        if (lego2 - lego1 < arr[end] - arr[start]) {
                            lego1 = arr[start];
                            lego2 = arr[end];
                        }
                    }
                    start++;
                    end--;
                }
            }

            if (lego1 == -1 || lego2 == -1) {
                System.out.println("danger");
            } else {
                System.out.println("yes " + lego1 + " " + lego2);
            }


        }
    }

}