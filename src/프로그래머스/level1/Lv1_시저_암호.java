package 프로그래머스.level1;

public class Lv1_시저_암호 {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        int c;

        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);

            if(c >= 'A' && c <= 'Z') c = ((c - 'A') + n) % 26 + 'A';
            else if(c >= 'a' && c <= 'z') c = ((c - 'a') + n) % 26 + 'a';

            answer.append((char)c);
        }
        return answer.toString();
    }
}
