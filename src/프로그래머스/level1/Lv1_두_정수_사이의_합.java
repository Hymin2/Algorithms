package 프로그래머스.level1;

public class Lv1_두_정수_사이의_합 {
    public long solution(int a, int b) {
        long answer = 0;
        long max = Math.max(a, b), min = Math.min(a, b);

        answer = (max * (max + 1) / 2) - ((min - 1) * min / 2);

        return answer;
    }
}
