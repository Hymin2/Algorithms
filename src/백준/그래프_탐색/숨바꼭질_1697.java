package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 숨바꼭질_1697 {
    static Queue<Integer> queue = new LinkedList<>();
    static int[] seconds;
    static boolean[] checked;

    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BFS(NK[0], NK[1]);
    }

    public static void BFS(int start, int end){
        seconds = new int[Math.max(start + 1, end + 2)];
        checked = new boolean[seconds.length];
        int position = 0;

        seconds[start] = 0;
        checked[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            position = queue.poll();

            if(position == end) break;
            if(position != 0 && !checked[position - 1]){
                visit(position - 1, seconds[position] + 1);
            }if(position + 1 != checked.length && !checked[position + 1]){
                visit(position + 1, seconds[position] + 1);
            }if(position * 2 < checked.length && !checked[position * 2]){
                visit(position * 2, seconds[position] + 1);
            }
        }

        System.out.println(seconds[end]);
    }

    public static void visit(int position, int second){
        queue.add(position);
        seconds[position] = second;
        checked[position] = true;
    }
}
