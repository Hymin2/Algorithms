package 프로그래머스.level1;

public class Lv1_하샤드_수 {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0, n = x;

        while(n != 0){
            sum += n % 10;
            n /= 10;
        }

        answer = x % sum == 0;

        return answer;
    }
}
