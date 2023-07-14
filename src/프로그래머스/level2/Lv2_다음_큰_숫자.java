package 프로그래머스.level2;

public class Lv2_다음_큰_숫자 {
    public int solution(int n) {
        int answer = 0;
        int cnt = countOne(n);

        while(true){
            n++;

            if(countOne(n) == cnt)
                return n;
        }
    }

    public int countOne(int n){
        int cnt = 0;

        while(true){
            cnt += n % 2;
            n /= 2;

            if(n == 1){
                cnt++;
                break;
            }
        }

        return cnt;
    }
}
