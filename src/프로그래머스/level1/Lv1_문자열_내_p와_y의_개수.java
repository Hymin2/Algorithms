package 프로그래머스.level1;

public class Lv1_문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        boolean answer = true;
        int p_num = 0, y_num = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
                p_num++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                y_num++;
        }

        answer = p_num == y_num;

        return answer;
    }
}
