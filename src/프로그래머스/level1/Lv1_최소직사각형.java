package 프로그래머스.level1;

public class Lv1_최소직사각형 {
    public int solution(int[][] sizes) {
        int answer = 0, temp;
        int row_max = 0, col_max = 0;

        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            if(row_max < sizes[i][0])
                row_max = sizes[i][0];
            if(col_max < sizes[i][1])
                col_max = sizes[i][1];
        }

        answer = row_max * col_max;
        return answer;
    }
}
