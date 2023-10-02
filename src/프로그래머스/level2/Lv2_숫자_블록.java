package 프로그래머스.level2;

public class Lv2_숫자_블록 {
    public int[] solution(long begin, long end) {
        int len = (int) (end - begin);
        int[] answer = new int[len + 1];

        for(int i = 0; i < len + 1; i++){
            answer[i] = gcd(begin + i);
        }

        return answer;
    }

    public int gcd(long num){
        int result = 1;

        if(num == 1) return 0;

        for(int i = 2; i * i <= num; i++){
            if(num % i == 0 && (num / i) <= 10000000){
                result = (int) (num / i);
                break;
            } else if(num % i == 0){
                result = i;
            }
        }

        return result;
    }
}
