package 프로그래머스.level1;

public class Lv1_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int rightmost = 0;

        for(int i = 0; i < section.length; i++){
            if(rightmost < section[i]){
                answer++;
                rightmost = section[i] + m - 1;
            }
        }
        return answer;
    }
}
