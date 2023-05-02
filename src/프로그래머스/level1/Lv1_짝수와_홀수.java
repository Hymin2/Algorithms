package 프로그래머스.level1;

public class Lv1_짝수와_홀수 {
    public String solution(int num) {
        String answer = num % 2 == 0 ? "Even" : "Odd";

        return answer;
    }
}
