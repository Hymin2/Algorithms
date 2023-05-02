package 프로그래머스.level1;

public class Lv1_핸드폰_번호_가리기 {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        int len = phone_number.length();
        answer.append("*".repeat(len - 4));

        for(int i = 4; i > 0; i--)
            answer.append(phone_number.charAt(len - i));

        return answer.toString();
    }
}
