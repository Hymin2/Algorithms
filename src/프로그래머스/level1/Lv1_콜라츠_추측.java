package 프로그래머스.level1;

public class Lv1_콜라츠_추측 {
    public int solution(int num) {
        int answer = 0;

        while(num != 1){
            if (num < 0) return -1;

            if(num % 2 == 0) num = num / 2;
            else if (num % 2 == 1) num = num * 3 + 1;


            answer++;
        }

        return answer;
    }
}
