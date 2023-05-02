package 프로그래머스.level1;

public class Lv1_정수_제곱근_판별 {
    public long solution(long n) {
        long answer = -1;
        long sqrt_n = (long)Math.sqrt(n * 1.0);

        if(sqrt_n * sqrt_n == n)
            answer = (sqrt_n + 1) * (sqrt_n + 1);

        return answer;
    }
}
