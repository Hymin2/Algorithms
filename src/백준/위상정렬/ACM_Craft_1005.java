package 백준.위상정렬;

import java.util.*;
import java.io.*;

public class ACM_Craft_1005 {
    static int n;
    static int k;
    static int w;
    static Map<Integer, Node> nodeMap;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        int testCase = toInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < testCase; i++){
            initCase();

            Queue<Node> pq = new LinkedList<>();
            int[] dp = new int[n + 1];

            for(int j = 1; j <= n; j++) {
                if (nodeMap.get(j).degree == 0) {
                    pq.add(nodeMap.get(j));
                    dp[j] = nodeMap.get(j).time;
                }
            }

            while (true) {
                Node n = pq.poll();

                if (n.equals(nodeMap.get(w))) {
                    sb.append(dp[w] + "\n");
                    break;
                }

                for (int k = 0; k < n.adjList.size(); k++) {
                    int index = n.adjList.get(k);
                    Node y = nodeMap.get(index);

                    dp[index] = Math.max(dp[index], dp[n.index] + y.time);
                    y.degree = y.degree - 1;

                    if (y.degree == 0) pq.add(y);
                }
            }
        }

        System.out.println(sb);
    }

    public static int toInt(String str){
        return Integer.parseInt(str);
    }

    public static void initCase() throws IOException{
        st = new StringTokenizer(br.readLine(), " ");

        n = toInt(st.nextToken());
        k = toInt(st.nextToken());

        nodeMap = new HashMap<>();

        for(int j = 1; j <= n; j++)
            nodeMap.put(j, new Node(j));

        st = new StringTokenizer(br.readLine(), " ");
        for(int j = 1; j <= n; j++)
            nodeMap.get(j).time = toInt(st.nextToken());

        for(int j = 0; j < k; j++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = toInt(st.nextToken());
            int y = toInt(st.nextToken());

            nodeMap.get(x).adjList.add(y);
            nodeMap.get(y).degree++;
        }

        st = new StringTokenizer(br.readLine(), " ");
        w = toInt(st.nextToken());
    }

    public static class Node {
        int index;
        int time;
        int degree;
        List<Integer> adjList;

        public Node(int index){
            this.index = index;
            adjList = new ArrayList<>();
        }
    }
}
