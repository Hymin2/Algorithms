package 프로그래머스.level1;

public class Lv1_3진법_뒤집기 {
    public int solution(int n) {
        int answer = 0;
        int place = 1;
        StringBuilder sb = new StringBuilder();

        for(; n != 0; n = n / 3){
            int remain = n % 3;
            sb.append(remain);
        }

        for(int i = sb.length() - 1; i >= 0; i--){
            answer += (sb.charAt(i) - '0') * Math.pow(3 , (place++ - 1));
        }
        return answer;
    }
}
