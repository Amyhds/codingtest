import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int tc = sc.nextInt();
            int result = 0;
            //점수별 학생수 기록하는 배열 생성(0점~100점) 및 초기화
            int[ ] score_list = new int[101];
            Arrays.fill(score_list, 0);
            //1000명 학생의 점수를 보고 점수별 학생수+1
            for(int i = 1; i <= 1000; i++)
            {
                int score = sc.nextInt();
                score_list[score]++;
            }
            //가장 많은 학생수를 저장
            int[ ] temp_list = score_list.clone();
            Arrays.sort(temp_list);
            int preq_score = temp_list[100];
            //가장 많은 학생수를 포함하며 가장 큰 점수를 찾기
            for(int i = 0; i < 101; i++)
            {
                if(score_list[i] == preq_score)
                {
                    result = i;
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}