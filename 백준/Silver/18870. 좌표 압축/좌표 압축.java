import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 개수 N
		int N = Integer.parseInt(bf.readLine());
		// 원소를 담는 원본 리스트
		List<Integer> list = new ArrayList<Integer>();
		// 정렬 리스트
		List<Integer> sortedList = new ArrayList<Integer>();
		// 인덱스와 값을 담을 Map 
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 값 리스트에 넣기
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		// 정렬 리스트 복제 후 정렬
		sortedList.addAll(list);
		Collections.sort(sortedList);
		// 인덱스
		int idx = 0;
		for (int i = 0; i < N; i++) {
			// Map에 정렬리스트 원소와 인덱스를 넣는다
			if(!map.containsKey(sortedList.get(i)))
				map.put(sortedList.get(i), idx++);
		}
		//키값(원본 원소)로 value(압축된 원소)를 찾는다
		for (int i = 0; i < N; i++) {
			if(map.containsKey(list.get(i))) {
				sb.append(map.get(list.get(i))).append(" ");
			}
		}
		System.out.println(sb);
	}

}