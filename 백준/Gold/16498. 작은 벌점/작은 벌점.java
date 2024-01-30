import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arrayA = new int[A];
        int[] arrayB = new int[B];
        int[] arrayC = new int[C];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < A; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrayA);
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < B; i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrayB);
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < C; i++) {
            arrayC[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrayC);

        int minDiff = Integer.MAX_VALUE;
        int currA, currB, currC1, currC2;
        for (int a = 0; a < A; a++) {
            if (minDiff == 0) {
                break;
            }
            currA = arrayA[a];
            currB = search(arrayB, currA);
            currC1 = search(arrayC, currA);
            currC2 = search(arrayC, currB);

            int max = Math.max(currA, Math.max(currB, currC1));
            int min = Math.min(currA, Math.min(currB, currC1));
            minDiff = Math.min(minDiff, Math.abs(max - min));

            max = Math.max(currA, Math.max(currB, currC2));
            min = Math.min(currA, Math.min(currB, currC2));
            minDiff = Math.min(minDiff, Math.abs(max - min));
        }
        System.out.println(minDiff);
    }

    public static int search(int[] array, int curr) {
        int start = 0;
        int end = array.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int mid = (start + end) / 2;
        int nearest = array[mid];
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] < curr) {
                start = mid + 1;
            } else if (array[mid] > curr) {
                end = mid - 1;
            } else {
                return array[mid];
            }

            if (checkNearest(array[mid], nearest, curr)) {
                nearest = array[mid];
            }
        }
        return nearest;
    }

    public static boolean checkNearest(int arrayNum, int arrayMid, int target) {
        return Math.abs(arrayNum - target) < Math.abs(arrayMid - target);
    }

}