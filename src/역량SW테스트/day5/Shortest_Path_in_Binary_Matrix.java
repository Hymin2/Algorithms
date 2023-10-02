package 역량SW테스트.day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix {
    int rLen;
    int cLen;

    boolean[][] visited;

    int[] dr = {1, 1, 1, -1, -1, -1, 0, 0};
    int[] dc = {1, -1, 0, 1, -1, 0, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        rLen = grid.length;
        cLen = grid.length;

        visited = new boolean[rLen][cLen];

        return BFS(grid);
    }

    public int BFS(int[][] grid){
        Queue<Point> queue = new LinkedList<>();

        if(grid[0][0] == 0){
            if(rLen == 1 && cLen == 1) return 1;

            queue.add(new Point(0, 0, 1, new ArrayList<>()));
            visited[0][0] = true;
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0; i < dr.length; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                int nd = p.distance + 1;

                if(!isValid(grid, nr, nc)) continue;

                List<Point> np = List.copyOf(p.route);
                np.add(p);

                if(nr == rLen -1 && nc == cLen - 1){
                    System.out.println(np.toString());
                    return nd;
                }

                queue.add(new Point(nr, nc, nd, np));

                visited[nr][nc] = true;

            }
        }

        return -1;
    }

    public boolean isValid(int[][] grid, int r, int c){
        if(r == -1 || r == rLen || c == -1 || c == cLen) return false;
        if(grid[r][c] == 1) return false;
        if(visited[r][c]) return false;

        return true;
    }

    class Point{
        int r;
        int c;
        int distance;
        List<Point> route;

        Point(int r, int c, int distance, List<Point> route){
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.route = route;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();

            for(Point p : route){
                sb.append("[" + p.r + ", " + p.c +  "] ");
            }

            return sb.toString();
        }
    }
}
