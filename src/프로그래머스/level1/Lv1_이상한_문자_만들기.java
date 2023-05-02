package 프로그래머스.level1;

public class Lv1_이상한_문자_만들기 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int c;
        int index = 0;

        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);

            if(c >= 'A' && c <= 'Z') c -= 'A';
            else if(c >= 'a' && c <= 'z') c -= 'a';

            if(c == ' ')
                index = 0;
            else if(index % 2 == 0){
                c = c + 'A';
                index++;
            }
            else if(index % 2 == 1){
                c = c + 'a';
                index++;
            }

            answer.append((char)c);
        }
        return answer.toString();
    }
}
