package 백준.분할_정복;

import java.util.*;
import java.io.*;

public class Z_1074 {
    static int sum = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Nrc[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = 2 << (Nrc[0] - 1);
        if(N <= Nrc[1] || N <= Nrc[2]) return;

        division(N, 0, 0, Nrc[2], Nrc[1]);

        System.out.println(sum);
    }

    public static void division(int N, int x, int y, int r, int c){
        if(x == r && y == c) return;

        if(r < x + N / 2 && c < y + N / 2){
            division(N / 2, x, y, r, c);
        } else if(r >= x + N / 2 && c < y + N / 2){
            sum += N * N / 4;
            division(N / 2, x + N / 2, y, r, c);
        } else if(r < x + N / 2 && c >= y + N / 2){
            sum += N * N / 2;
            division(N / 2, x, y + N / 2, r, c);
        } else if(r >= x + N / 2 && c >= y + N / 2){
            sum += N * N / 4 * 3;
            division(N / 2, x + N / 2, y + N / 2, r, c);
        }
    }
}
