package 프로그래머스.level1;

public class Lv1_콜라_문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n >= a){
            answer += n / a * b;
            n = (n / a * b) + n % a;
        }
        return answer;
    }
}
