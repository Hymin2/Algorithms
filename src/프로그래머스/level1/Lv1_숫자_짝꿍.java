package 프로그래머스.level1;

public class Lv1_숫자_짝꿍 {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int x_length = X.length(), y_length = Y.length(), index;
        int[] number_X = new int[10];
        int[] number_Y = new int[10];

        for(int i = 0; i < Math.max(x_length, y_length); i++){
            if(i < x_length){
                number_X[X.charAt(i) - '0']++;
            }
            if(i < y_length){
                number_Y[Y.charAt(i) - '0']++;
            }
        }

        for(int i = 9; i >= 0; i--){
            answer.append(String.valueOf(i).repeat(Math.min(number_X[i], number_Y[i])));
        }

        if(answer.length() == 0) return "-1";
        if(answer.charAt(0) == '0') return "0";


        return answer.toString();
    }
}
