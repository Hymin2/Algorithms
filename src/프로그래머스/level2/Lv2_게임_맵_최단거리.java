package 프로그래머스.level2;

import java.util.*;

public class Lv2_게임_맵_최단거리 {
    public int solution(int[][] maps) {
        int answer = 0, n = maps.length, m = maps[0].length;
        Graph g = new Graph(n, m);

        g.initGraph(n, m, maps);
        answer = g.bfs();

        return answer;
    }
}

class Graph{
    Vertex[] vertices;

    Graph(int n, int m){
        vertices = new Vertex[n * m];
    }

    public void initGraph(int n, int m, int[][] maps){
        for(int i = 0; i < n; i++){
            for(int k = 0; k < m; k++){
                Vertex v = new Vertex();
                int v_num = i * m + k;

                if(i != 0 && maps[i - 1][k] == 1) v.setAdjList(v_num - m);
                if(k != 0 && maps[i][k - 1] == 1) v.setAdjList(v_num - 1);
                if(i != n - 1 && maps[i + 1][k] == 1) v.setAdjList(v_num + m);
                if(k != m - 1 && maps[i][k + 1] == 1) v.setAdjList(v_num + 1);

                vertices[v_num] = v;
            }
        }
    }

    public int bfs(){
        Queue<Integer> q = new LinkedList<>();

        vertices[0].setDistance(1);
        vertices[0].visit();
        q.add(0);

        while(!q.isEmpty()){
            int u = q.peek();
            q.poll();

            for(int v_num : vertices[u].getAdjList()){
                if(!vertices[v_num].getVisited()){
                    vertices[v_num].visit();
                    vertices[v_num].setDistance(vertices[u].getDistance() + 1);
                    vertices[v_num].prev = u;

                    q.add(v_num);
                }
            }
        }

        return vertices[vertices.length - 1].getDistance();
    }
}

class Vertex{
    int d;
    boolean visited;
    int prev;
    List<Integer> adjlist;

    Vertex(){
        d = -1;
        visited = false;
        adjlist = new ArrayList<>();
    }

    void visit(){
        visited = true;
    }

    boolean getVisited(){
        return visited;
    }

    int getDistance(){
        return d;
    }

    void setDistance(int d){
        this.d = d;
    }

    void setPrevVertex(int prev){
        this.prev = prev;
    }

    void setAdjList(int v){
        adjlist.add(v);
    }

    List<Integer> getAdjList(){
        return adjlist;
    }

    void setPrev(int prev){
        this.prev = prev;
    }

    int getPrev(){
        return prev;
    }
}
