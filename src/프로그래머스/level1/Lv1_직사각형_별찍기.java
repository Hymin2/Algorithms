package 프로그래머스.level1;

import java.util.Scanner;

public class Lv1_직사각형_별찍기 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < b; i++){
            stringBuilder.append("*".repeat(a));
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
