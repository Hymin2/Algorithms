package 프로그래머스.level1;

public class Lv1_평균_구하기 {
    public double solution(int[] arr) {
        double answer = 0;

        for(int i = 0; i < arr.length; i++)
            answer += arr[i];

        answer /= arr.length;

        return answer;
    }
}
