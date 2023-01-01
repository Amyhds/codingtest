import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{   
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        //테스트 케이스 별
		for(int test_case = 1; test_case <= T; test_case++)
		{
            //답 변수 생성
            int result = 0;
            //N, M, 배열 A, B 입력 받기
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[ ] A = new int[N];
            int[ ] B = new int[M];
            for(int a = 0; a < N; a++)
            {
                A[a] = sc.nextInt();
            }
            for(int b = 0; b < M; b++)
            {
                B[b] = sc.nextInt();
            }
            // 최대값 계산
            if(N > M)
            {
                result = calculate(A, B);
            } else
            {
                result = calculate(B, A);
            }
            // 결과 출력
            System.out.print("#"+test_case+" "+result+"\n");
		}
	}
    
    //최대값 계산 함수
    public static int calculate(int[ ] L, int[ ] S) throws Exception
    {
        // 최대값 설정
        int max = 0;
        // 모든 결과 계산
        for(int i = 0; i < L.length - S.length + 1; i++)
        {
            int temp = 0;
            for(int j = 0; j < S.length; j++)
            {
                temp += L[i + j] * S[j];
            }
            if(temp > max)
            {
                max = temp;
            }
        }
        //최대값 반환
        return max;
    }
}