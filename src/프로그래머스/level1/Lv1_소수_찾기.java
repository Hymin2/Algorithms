package 프로그래머스.level1;

public class Lv1_소수_찾기 {
    public int solution(int n) {
        int answer = 0;
        int[] cnt = new int[n + 1];

        for(int i = 1; i <= n; i++){
            for(int k = 1; k <= n / i; k++){
                cnt[i * k]++;
            }
        }

        for(int i = 1; i < cnt.length; i++){
            if(cnt[i] == 2) answer++;
        }
        return answer;
    }
}
