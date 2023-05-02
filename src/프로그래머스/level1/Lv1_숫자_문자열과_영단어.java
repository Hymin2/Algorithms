package 프로그래머스.level1;

public class Lv1_숫자_문자열과_영단어 {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < numbers.length; i++){
            s = s.replace(numbers[i], String.valueOf(i));
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
