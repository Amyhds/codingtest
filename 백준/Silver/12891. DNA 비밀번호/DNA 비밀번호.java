import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int S;
	static int P;
	static String dna;
	static int[] containP;
	static int[] checkCnt;
	static int res;
	
	private static boolean isValid() {
		for (int i = 0; i < 4; i++) {
			if (checkCnt[i] < containP[i]) return false;
		}
		return true;
	}

	private static void addCnt(int loc) {
		if (dna.charAt(loc) == 'A')
			checkCnt[0]++;
		if (dna.charAt(loc) == 'C')
			checkCnt[1]++;
		if (dna.charAt(loc) == 'G')
			checkCnt[2]++;
		if (dna.charAt(loc) == 'T')
			checkCnt[3]++;
	}
	
	private static void subCnt(int loc) {
		if (dna.charAt(loc) == 'A')
			checkCnt[0]--;
		if (dna.charAt(loc) == 'C')
			checkCnt[1]--;
		if (dna.charAt(loc) == 'G')
			checkCnt[2]--;
		if (dna.charAt(loc) == 'T')
			checkCnt[3]--;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 길이
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		// dna 문자열
		dna = bf.readLine();
		// 포함 조건
		st = new StringTokenizer(bf.readLine());
		containP = new int[4];
		for (int i = 0; i < 4; i++) {
			containP[i] = Integer.parseInt(st.nextToken());
		}
		// 개수 저장 배열 생성
		checkCnt = new int[4];
		// 첫번째 부분문자열 체크
		for (int i = 0; i < P; i++) {
			addCnt(i);
		}
		// 첫부분 유효한지 체크
		if(isValid()) res++;
		// 이후 부분문자열 체크
		for (int i = 1; i <= S - P; i++) {
			subCnt(i - 1);
			addCnt(i + P - 1);
			// 유효 체크
			if(isValid()) res++;
		}
		
		System.out.println(res);
	}

}
