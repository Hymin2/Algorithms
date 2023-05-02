package 프로그래머스.level1;

public class Lv1_가운데_글자_가져오기 {
    public String solution(String s) {
        int len = s.length();
        String answer = len % 2 == 1 ? s.substring(len / 2, len / 2 + 1) : s.substring(len / 2 - 1, len / 2 + 1);

        return answer;
    }
}
