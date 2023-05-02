package 프로그래머스.level1;

public class Lv1_2016년 {
    public String solution(int a, int b) {
        int[] month_days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weeks = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int sum = 0;

        for(int i = 0; i < a - 1; i++)
            sum += month_days[i];
        sum += b;

        return weeks[sum % 7];
    }
}
