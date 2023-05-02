package 프로그래머스.level2;

public class Lv2_당구_연습 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int num = balls.length;
        int[] answer = new int[num];
        int[] dis_wall = new int[4];
        int min = 1000001, min_index = 0;

        for(int i = 0; i < num; i++){
            dis_wall[0] = ((startX + balls[i][0]) * (startX + balls[i][0])) + (Math.abs(startY - balls[i][1]) * Math.abs(startY - balls[i][1]));
            dis_wall[1] = ((m - startX + m - balls[i][0]) * (m - startX + m - balls[i][0])) + (Math.abs(startY - balls[i][1]) * Math.abs(startY - balls[i][1]));
            dis_wall[2] = (Math.abs(startX - balls[i][0]) * Math.abs(startX - balls[i][0])) + ((startY + balls[i][1]) * (startY + balls[i][1]));
            dis_wall[3] = (Math.abs(startX - balls[i][0]) * Math.abs(startX - balls[i][0])) + ((n - startY + n - balls[i][1]) * (n - startY + n - balls[i][1]));

            for(int k = 0; k < 4; k++){
                if(min > dis_wall[k]){
                    if(k == 0 && startY == balls[i][1] && startX > balls[i][0]) continue;
                    if(k == 1 && startY == balls[i][1] && startX < balls[i][0]) continue;
                    if(k == 2 && startX == balls[i][0] && startY > balls[i][1]) continue;
                    if(k == 3 && startX == balls[i][0] && startY < balls[i][1]) continue;
                    min = dis_wall[k];
                    min_index = k;
                }
            }

            answer[i] = dis_wall[min_index];
            min = 1000001;
        }

        return answer;
    }
}
