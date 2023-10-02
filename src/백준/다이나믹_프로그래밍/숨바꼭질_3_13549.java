package 백준.다이나믹_프로그래밍;

import java.io.*;
import java.util.*;

public class 숨바꼭질_3_13549 {
    static int[] NK;
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.fill(time, 100000);
        time[NK[0]] = 0;

        if(NK[0] > NK[1]) System.out.println(NK[0] - NK[1]);
        else {
            BFS(NK[0]);
            System.out.println(time[NK[1]]);
        }
    }

    public static void BFS(int start){
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));

        queue.add(new Point(start, 0));

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.time > time[p.x]) continue;

            int dx = p.x + 1;
            if(isValid(dx) && time[dx] > p.time + 1){
                time[dx] = p.time + 1;
                queue.add(new Point(dx, p.time + 1));
            }


            dx = p.x - 1;
            if(isValid(dx) && time[dx] > p.time + 1){
                time[dx] = p.time + 1;
                queue.add(new Point(dx, p.time + 1));
            }

            dx = p.x * 2;
            if(isValid(dx) && time[dx] > p.time){
                time[dx] = p.time;
                queue.add(new Point(dx, p.time));
            }
        }
    }

    public static boolean isValid(int num){
        if(num <= 0 || num >= 100001) return false;
        return true;
    }

    static class Point{
        int x;
        int time;

        Point(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
}
