import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{    
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 별
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            //테스트 케이스 번호 입력 받기
            int tc = sc.nextInt();
            //배열 입력 받기
            int[ ][ ] arr = new int[100][100];
            for(int i = 0; i < 100; i++)
            {
                for(int j = 0; j < 100; j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            //변수 생성
            int row_sum = 0;
            int col_sum = 0;
            int diag1_sum = 0;
            int diag2_sum = 0;
            int result = 0;
            //합 구하기
            for(int i = 0; i < 100; i++)
            {
                row_sum = 0;
                col_sum = 0;
                diag1_sum += arr[i][i];
                diag2_sum += arr[i][99-i];
                for(int j = 0; j < 100; j++)
                {
                    row_sum += arr[i][j];
                    col_sum += arr[j][i];
                }
                result = Math.max(result, row_sum);
                result = Math.max(result, col_sum);
            }
            result = Math.max(result, diag1_sum);
            result = Math.max(result, diag2_sum);
            //결과 출력
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}