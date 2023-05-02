package 프로그래머스.level1;

public class Lv1_행렬의_덧셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int len_row = arr1.length;
        int len_col = arr1[0].length;

        int[][] answer = new int[len_row][len_col];

        for(int i = 0; i < len_row; i++){
            for(int k = 0; k < len_col; k++){
                answer[i][k] = arr1[i][k] + arr2[i][k];
            }
        }
        return answer;
    }
}
