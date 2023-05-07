package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 트리의_부모_찾기_11725 {
    static int N;
    //static Map<Integer, List<Integer>> adjList = new HashMap<>();
   // static Map<Integer, Integer> prevNode = new HashMap<>();
    static List<Integer>[] adjArray;
    static int[] prev;
    public static void main(String[] args) throws IOException{
        N = read();
        adjArray = new ArrayList[N + 1];
        prev = new int[N + 1];

        /*

        for(int i = 1; i <= N; i++){
            adjList.put(i, new ArrayList<>());
        }

         */

        for(int i = 1; i <= N; i++)
            adjArray[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++){
            int u = read();
            int v = read();

            // adjList.get(u).add(v);
            // adjList.get(v).add(u);

            adjArray[u].add(v);
            adjArray[v].add(u);
        }

        BFS();

        for(int i = 2; i <= N; i++)
            System.out.println(prev[i]);
    }

    /*
    public static void DFS(){
        boolean[] checked = new boolean[N + 1];

        DFS_visit(1, checked);
    }

    public static void DFS_visit(int node, boolean[] checked){
        checked[node] = true;

        for(int u : adjList.get(node)){
            if(!checked[u]){
                prevNode.put(u, node);
                DFS_visit(u, checked);
            }
        }
    }

     */

    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] checked = new boolean[N + 1];

        queue.add(1);

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i = 0; i < adjArray[node].size(); i++){
                int u = adjArray[node].get(i);
                if(!checked[u]){
                    prev[u] = node;
                    checked[u] = true;
                    queue.add(u);
                }
            }
        }
    }

    private static int read() throws IOException{
        int c, n = System.in.read() & 15;

        while( (c=System.in.read()) > 32) {
            n = (n<<3) + (n<<1) + (c&15);
        }

        if(c == 13) {
            System.in.read();
        }

        return n;
    }
}
