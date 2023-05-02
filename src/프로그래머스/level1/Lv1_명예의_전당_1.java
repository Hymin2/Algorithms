package 프로그래머스.level1;

public class Lv1_명예의_전당_1 {
    public int[] solution(int k, int[] score) {
        int num = score.length;
        int[] answer = new int[num];
        int[] top_k = new int[k];
        int min = 2001, min_index = 0;

        for(int i = 0; i < num; i++){
            if(i < k){
                top_k[i] = score[i];

                if(min > score[i]){
                    min = score[i];
                    min_index = i;
                }
                answer[i] = min;
            }

            else {
                min = 2001;

                if (top_k[min_index] < score[i]) {
                    top_k[min_index] = score[i];

                    for (int j = 0; j < k; j++) {
                        if (min > top_k[j]) {
                            min = top_k[j];
                            min_index = j;
                        }
                    }
                }
                answer[i] = top_k[min_index];
            }
        }

        return answer;
    }
}
