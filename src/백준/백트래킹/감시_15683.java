package 백준.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 감시_15683 {
    static int[][] cctv = {{}, {1, 2, 3, 4}, {1, 2}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1}};
    static int[][]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int k = 0; k < M; k++)
                map[i][k] = Integer.parseInt(st.nextToken());
        }


    }
}
