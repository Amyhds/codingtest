import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static String S;
	private static String T;

	public static boolean isSame(String S, String T) {
		StringBuilder sb_s = new StringBuilder();
		StringBuilder sb_t = new StringBuilder();

		int s = S.length();
		int t = T.length();
		int gcd = 0;
		for (int i = 1; i <= t; i++) {
			if (s % i == 0 && t % i == 0) {
				gcd = i;
			}
		}
		int repeat = s * t / gcd;
		for (int i = 0; i < repeat / s; i++) {
			sb_s.append(S);

		}
		for (int i = 0; i < repeat / t; i++) {
			sb_t.append(T);

		}
		if (sb_s.toString().equals(sb_t.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String tmp1 = st.nextToken();
			String tmp2 = st.nextToken();
			if (tmp1.length() > tmp2.length()) {
				S = tmp1;
				T = tmp2;
			} else {
				S = tmp2;
				T = tmp1;
			}
			if (isSame(S, T)) {
				System.out.println("#" + test_case + " yes");
			} else {
				System.out.println("#" + test_case + " no");
			}

		}

	}

}