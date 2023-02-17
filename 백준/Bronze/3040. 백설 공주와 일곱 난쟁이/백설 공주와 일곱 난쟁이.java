import java.util.Scanner;

public class Main {

	static int[] dwarf;
	static boolean[] isSelected;

	private static void find(int start, int cnt, int sum) {
		
		if (cnt == 7) {			
			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (!isSelected[i])
						continue;
					System.out.println(dwarf[i]);
				}
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			isSelected[i] = true;
			find(i + 1, cnt + 1, sum + dwarf[i]);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		dwarf = new int[9];
		isSelected = new boolean[9];

		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}

		find(0, 0, 0);

	}

}