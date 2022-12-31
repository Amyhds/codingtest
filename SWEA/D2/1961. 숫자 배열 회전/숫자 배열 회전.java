import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    // 회전 함수
    public static int[ ][ ] rotate(int[ ][ ] arr) throws Exception
    {
        int size = arr[0].length;
        int[ ][ ] rotate_arr = new int[size][size];
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                rotate_arr[row][size-1-col] = arr[col][row];
            }
        }
        return rotate_arr;
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        // 테스트 케이스 1개씩
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // N 입력받음
            int N = sc.nextInt();
            // 배열 선언 및 초기화
            int[ ][ ] arr = new int[N][N];
            for(int i = 0; i < N; i++) 
            {
                for(int j = 0; j < N; j++) 
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            // 회전 3번
            int[ ][ ] arr_90 = rotate(arr);
            int[ ][ ] arr_180 = rotate(arr_90);
            int[ ][ ] arr_270 = rotate(arr_180);
            // 출력
            System.out.print("#" + test_case + "\n");
            for(int i = 0; i < N; i++) 
            {
                for(int j = 0; j < N; j++) 
                {
                    System.out.print(arr_90[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++) 
                {
                    System.out.print(arr_180[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++) 
                {
                    System.out.print(arr_270[i][j]);
                }                
                System.out.print("\n");
            }
		}
	}
}