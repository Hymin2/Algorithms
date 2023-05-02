package 프로그래머스.level1;

public class Lv1_성격_유형_검사하기 {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int[] score = new int[4];
        String[] types = {"R", "C", "J", "A"};
        String[] other_types = {"T", "F", "M", "N"};
        int index;

        for(int i = 0; i < survey.length; i++){
            for(int k = 0; k < types.length; k++){
                if((index = survey[i].indexOf(types[k])) != -1){
                    if(index == 0) score[k] -= (choices[i] - 4);
                    else if(index == 1) score[k] += (choices[i] - 4);
                }
            }
        }

        for(int i = 0; i < types.length; i++){
            if(score[i] >= 0) answer.append(types[i]);
            else answer.append(other_types[i]);
        }

        return answer.toString();
    }
}
