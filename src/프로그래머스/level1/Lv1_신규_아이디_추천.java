package 프로그래머스.level1;

public class Lv1_신규_아이디_추천 {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        final int MAX_LENGTH = 15;
        int index = 0;

        for(int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);

            if(c == '.' && (index == 0 || answer.charAt(index - 1) == '.' || i == new_id.length() - 1)) continue;
            if(c >= 'A' && c <= 'Z') c += 'a' - 'A';
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                answer.append(c);
                index++;
            }
        }

        if(answer.length() == 0) answer.append('a');
        if(answer.length() > MAX_LENGTH) answer.delete(15, answer.length());
        if(answer.length() != 0 && answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);
        if(answer.length() < 3) answer.append(answer.substring(answer.length() - 1).repeat(3 - answer.length()));


        return answer.toString();
    }
}
