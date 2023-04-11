import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String bomb = bf.readLine();
		int len = bomb.length();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			stack.push(temp);
			boolean isSame = true;
			if (stack.size() >= len) {
				for (int j = 0; j < len; j++) {
					if (stack.get(stack.size() - len + j) != bomb.charAt(j))
						isSame = false;
				}
				if (isSame) {
					for (int j = 0; j < len; j++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
	}

}