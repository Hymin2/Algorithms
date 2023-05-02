package 프로그래머스.level1;

public class Lv1_부족한_금액_계산하기 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = count * (count + 1) / 2;

        if(price * sum > money) return price * sum - money;
        else return 0;

    }
}
