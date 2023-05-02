package 프로그래머스.level1;

public class Lv1_약수의_개수와_덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        int[] cnt = new int[right - left + 1];

        for(int i = left; i <= right; i++){
            for(int k = 1; k * k <= i; k++){
                if(k * k == i){
                    cnt[i - left]++;
                    continue;
                }
                if(i % k == 0) cnt[i - left] += 2;
            }
        }

        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] % 2 == 0) answer += (i + left);
            else answer -= (i + left);
        }

        return answer;
    }
}
