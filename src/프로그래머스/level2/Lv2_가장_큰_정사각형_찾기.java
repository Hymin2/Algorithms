package 프로그래머스.level2;

public class Lv2_가장_큰_정사각형_찾기 {
    public int solution(int [][]board)
    {
        int answer = 1234;
        int max = 0;
        int[][] dp = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            dp[i][0] = board[i][0];

            if(board[i][0] == 1) max = 1;
        }
        for(int i = 0; i < board[0].length; i++){
            dp[0][i] = board[0][i];

            if(board[0][i] == 1) max = 1;
        }

        for(int i = 1; i < board.length; i++){
            for(int k = 1; k < board[0].length; k++){
                if(board[i][k] == 1){
                    dp[i][k] = Math.min(Math.min(dp[i - 1][k], dp[i][k - 1]), dp[i - 1][k - 1]) + 1;

                    max = Math.max(max, dp[i][k]);
                }
            }
        }

        answer = max * max;

        return answer;
    }
}
