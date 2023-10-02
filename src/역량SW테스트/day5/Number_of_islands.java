package 역량SW테스트.day5;

public class Number_of_islands {
    int xLen;
    int yLen;

    boolean[][] visited;
    char[][] map;

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        xLen = grid.length;
        yLen = grid[0].length;

        visited = new boolean[xLen][yLen];
        map = grid;

        return DFS();
    }

    public int DFS(){
        int cnt = 0;

        for(int i = 0; i < xLen; i++){
            for(int k = 0; k < yLen; k++){
                if(!visited[i][k] && map[i][k] == '1'){
                    DFS_visit(i, k);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void DFS_visit(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx == -1 || nx == xLen || ny == -1 || ny == yLen) continue;

            if(!visited[nx][ny] && map[nx][ny] == '1') DFS_visit(nx, ny);
        }
    }
}
