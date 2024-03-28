import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][2];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            int index = node - 'A';
            if (left == '.') {
                arr[index][0] = -1;
            } else {
                arr[index][0] = left - 'A';
            }
            if (right == '.') {
                arr[index][1] = -1;
            } else {
                arr[index][1] = right - 'A';
            }
        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    public static void preorder(int curr) {
        System.out.print((char) (curr + 'A'));
        if (arr[curr][0] > 0) {
            preorder(arr[curr][0]);
        }
        if (arr[curr][1] > 0) {
            preorder(arr[curr][1]);
        }
    }

    public static void inorder(int curr) {
        if (arr[curr][0] > 0) {
            inorder(arr[curr][0]);
        }
        System.out.print((char) (curr + 'A'));
        if (arr[curr][1] > 0) {
            inorder(arr[curr][1]);
        }
    }

    public static void postorder(int curr) {
        if (arr[curr][0] > 0) {
            postorder(arr[curr][0]);
        }
        if (arr[curr][1] > 0) {
            postorder(arr[curr][1]);
        }
        System.out.print((char) (curr + 'A'));
    }

}