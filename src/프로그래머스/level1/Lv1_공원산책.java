package 프로그래머스.level1;

import java.util.*;

public class Lv1_공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] temp = new int[2];
        int row_max = park.length, col_max = park[0].length();
        int i, k;

        for(i = 0; i < park.length; i++){
            for(k = 0; k < park[i].length(); k++){
                if(park[i].charAt(k) == 'S'){
                    answer[0] = i;
                    answer[1] = k;

                    break;
                }
            }
        }

        for(i = 0; i < routes.length; i++){
            temp[0] = answer[0];
            temp[1] = answer[1];

            char direction = routes[i].charAt(0);
            char num = routes[i].charAt(2);
            switch (direction){
                case 'N':
                    temp[0] -= (num - '0');
                    break;
                case 'S':
                    temp[0] += (num - '0');
                    break;
                case 'W':
                    temp[1] -= (num - '0');
                    break;
                case 'E':
                    temp[1] += (num - '0');
                    break;
            }

            if(temp[0] < 0 || temp[0] >= row_max) continue;
            if(temp[1] < 0 || temp[1] >= col_max) continue;
            if(isExistWall(park, direction, num, answer[0], answer[1])) continue;


            answer[0] = temp[0];
            answer[1] = temp[1];
        }

        return answer;
    }

    public boolean isExistWall(String[] park, char direction, char num, int row, int col){
        for(int i = 1; i <= num - '0'; i++){
            switch (direction){
                case 'N':
                    if(park[row - i].charAt(col) == 'X') return true;
                    break;
                case 'S':
                    if(park[row + i].charAt(col) == 'X') return true;
                    break;
                case 'W':
                    if(park[row].charAt(col - i) == 'X') return true;
                    break;
                case 'E':
                    if(park[row].charAt(col + i) == 'X') return true;
                    break;
            }
        }
        return false;
    }
}
