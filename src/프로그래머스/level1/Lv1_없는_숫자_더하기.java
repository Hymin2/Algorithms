package 프로그래머스.level1;

public class Lv1_없는_숫자_더하기 {
    public int solution(int[] numbers) {
        int answer = 45;

        for(int num : numbers)
            answer -= num;

        return answer;
    }
}
