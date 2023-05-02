package 프로그래머스.level1;

public class Lv1_약수의_합 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i * i <= n; i++){
            if(i * i == n){
                answer += i;
                continue;
            }

            if(n % i == 0){
                answer += i;
                answer += n / i;
            }
        }
        return answer;
    }
}
