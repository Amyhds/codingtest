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
        int[ ][ ] sudoku = new int[9][9];
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 1;
            for(int row = 0; row < 9; row++)
            {
                for(int col = 0; col < 9; col++)
                {
                    sudoku[row][col] = sc.nextInt();
                }
            }
            //row and col
            for(int row = 0; row < 9; row++)
            {
                int[ ] check_row = new int[9]; 
                int[ ] check_col = new int[9]; 
                Arrays.fill(check_row, 0);
                Arrays.fill(check_col, 0);
                for(int col = 0; col < 9; col++)
                {
                    check_row[sudoku[row][col] - 1] = 1;
                    check_col[sudoku[col][row] - 1] = 1;
                }
                for(int i = 0; i < 9; i++)
                {
                    if(check_row[i] == 0)
                    {
                        answer = 0;
                        break;
                    }
                    if(check_col[i] == 0)
                    {
                        answer = 0;
                        break;
                    }
                }
            }
            //3*3
            for(int row = 0; row < 9; row += 3)
            {
                for(int col = 0; col < 9; col += 3)
                {
                    int[ ] check_square = new int[9];
                    Arrays.fill(check_square, 0);
                    for(int i = 0; i < 3; i++) 
                    {
                        for(int j = 0; j < 3; j++)
                        {
                            check_square[sudoku[row + i][col + j] - 1] = 1;
                        }
                    }
                    for(int k = 0; k < 9; k++)
                    {
                        if(check_square[k] == 0)
                        {
                            answer = 0;
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + (test_case) + " " + answer);   
        }
    }
}