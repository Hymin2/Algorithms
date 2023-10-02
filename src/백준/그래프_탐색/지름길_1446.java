package 백준.그래프_탐색;

import java.io.*;
import java.util.*;

public class 지름길_1446 {
    static Map<Integer, List<Shortcut>> hashMap = new HashMap<>();
    static int[] ND;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ND = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        distance = new int[ND[1] + 1];

        Arrays.fill(distance, 10001);

        for(int i = 0; i < ND[0]; i++){
            int[] shortcut = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(hashMap.getOrDefault(shortcut[0], null) == null) hashMap.put(shortcut[0], new ArrayList<>());

            hashMap.get(shortcut[0]).add(new Shortcut(shortcut[1], shortcut[2]));
        }

        dijkstra();

        System.out.println(distance[ND[1]]);
    }

    public static void dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(q -> q.distance));

        pq.add(new Point(0, 0));

        while(!pq.isEmpty()){
            Point p = pq.poll();

            if(p.x > ND[1] || distance[p.x] < p.distance) continue;
            distance[p.x] = p.distance;

            List<Shortcut> shortcutList = hashMap.getOrDefault(p.x, null);

            if(shortcutList != null){
                for(Shortcut shortcut : shortcutList){
                    pq.add(new Point(shortcut.end, shortcut.distance + p.distance));
                }
            }
            pq.add(new Point(p.x + 1, p.distance + 1));
        }
    }

    static class Point{
        int x;
        int distance;

        Point(int x, int distance){
            this.x = x;
            this.distance = distance;
        }
    }

    static class Shortcut{
        int end;
        int distance;

        Shortcut(int end, int distance){
            this.end = end;
            this.distance = distance;
        }
    }
}
