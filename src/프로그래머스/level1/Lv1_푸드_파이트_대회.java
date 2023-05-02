package 프로그래머스.level1;

public class Lv1_푸드_파이트_대회 {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();

        for(int i = 1; i < food.length; i++){
            answer.append(String.valueOf(i).repeat(food[i] / 2));
        }
        answer.append(0);

        for (int i = food.length - 1; i >= 1; i--){
            answer.append(String.valueOf(i).repeat(food[i] / 2));
        }

        return answer.toString();
    }
}
