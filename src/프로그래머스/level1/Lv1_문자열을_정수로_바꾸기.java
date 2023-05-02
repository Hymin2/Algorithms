package 프로그래머스.level1;

public class Lv1_문자열을_정수로_바꾸기 {
    public int solution(String s) {
        int answer = 0;

        if(s.charAt(0) == '+') answer = Integer.parseInt(s.substring(1, s.length()));
        else if(s.charAt(0) == '-')answer = Integer.parseInt(s.substring(1, s.length())) * -1;
        else answer = Integer.parseInt(s);

        return answer;
    }
}
