package 프로그래머스.level1;

public class Lv1_문자열_다루기_기본 {
    public boolean solution(String s) {
        boolean answer = true;

        answer = s.matches("[0-9]{4}") || s.matches("[0-9]{6}");

        return answer;
    }
}
