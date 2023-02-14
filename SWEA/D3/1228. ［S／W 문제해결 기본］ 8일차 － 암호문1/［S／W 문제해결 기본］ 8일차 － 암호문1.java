import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static LinkedList<String> origin;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(bf.readLine()); // 암호문 길이
			StringTokenizer st = new StringTokenizer(bf.readLine());
			origin = new LinkedList<>(); // 암호문 저장 연결리스트
			
			for (int i = 0; i < N; i++) {
				origin.add(st.nextToken()); // 원본 저장
			}
			
			int K = Integer.parseInt(bf.readLine()); // 명령어 개수
			st = new StringTokenizer(bf.readLine());
			
			for(int i = 0; i < K; i++) {
				st.nextToken();				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
			
				for (int j = 0; j < y; j++) {
					origin.add(x, st.nextToken()); // x 다음 위치에
					x++; // x는 계속 늘려나가야 y개의 숫자가 일렬로 올 수 있음
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(origin.remove() + " "); // 10개만 출력
			}
			System.out.println();
		}
	}

}
