package 프로그래머스.level1;

import java.util.Arrays;

public class Lv1_햄버거_만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;
        int index = 2;
        StringBuilder stringBuilder = new StringBuilder(Arrays.toString(ingredient).replace(", ", ""));

        while((index = stringBuilder.indexOf("1231", index - 2)) != -1) {
            answer++;

            stringBuilder.delete(index, index + 4);
        }

        return answer;
    }
}
