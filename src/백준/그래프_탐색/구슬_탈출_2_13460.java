package 백준.그래프_탐색;

import java.util.*;
import java.io.*;

public class 구슬_탈출_2_13460 {
    static char[][] map;
    static boolean[][][][] visited;
    static int n;
    static int m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public enum Direction{
        BOTTOM(0), TOP(1), RIGHT(2), LEFT(3), NONE(4);

        int num;

        Direction(int num) {
            this.num = num;
        }

        public static Direction findByNum(int num){
            return Arrays.stream(Direction.values()).filter((i) -> i.num == num).findFirst().orElse(null);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = NM[0];
        m = NM[1];

        map = new char[n][m];
        visited = new boolean[n][m][n][m];

        for(int i = 0; i < NM[0]; i++)
            map[i] = br.readLine().toCharArray();

        int redStartX = 0;
        int redStartY = 0;
        int blueStartX = 0;
        int blueStartY = 0;

        for(int i = 0; i < n; i++){
            for(int k = 0; k < m; k++){
                if(map[i][k] == 'R'){
                    redStartX = i;
                    redStartY = k;
                } else if(map[i][k] == 'B'){
                    blueStartX = i;
                    blueStartY = k;
                }
            }
        }

        int result = BFS(redStartX, redStartY, blueStartX, blueStartY);

        System.out.println(result);
    }

    public static int BFS(int redStartX, int redStartY, int blueStartX, int blueStartY){
        Queue<Point> queue = new LinkedList<>();
        int min = -1;

        queue.add(new Point(redStartX, redStartY, blueStartX, blueStartY));
        visited[redStartX][redStartY][blueStartX][blueStartY] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(map[p.redX][p.redY] == 'O' && map[p.blueX][p.blueY] != '0'){
                if(min == -1) min = p.distance;
                else min = Math.min(min, p.distance);
            }

            for (int i = 0; i < dx.length; i++) {
                Direction direction = Direction.findByNum(i);

                Point np = moveMarble(p, direction);

                if(!isValid(np.redX, np.redY, np.blueX, np.blueY)) continue;
                if(map[np.blueX][np.blueY] == 'O') continue;

                queue.add(new Point(np.redX, np.redY, p.distance + 1, np.blueX, np.blueY));
                visited[np.redX][np.redY][np.blueX][np.blueY] = true;
            }
        }

        return min;
    }

    public static Point moveMarble(Point p, Direction direction){
        int redX = p.redX;
        int redY = p.redY;
        int redCnt = 0;
        int blueX = p.blueX;
        int blueY = p.blueY;
        int blueCnt = 0;

        int nx = p.redX;
        int ny = p.redY;

        while(true){
            nx = nx + dx[direction.ordinal()];
            ny = ny + dy[direction.ordinal()];

            if(!isMoved(nx, ny)) break;

            redCnt++;
            redX = nx;
            redY = ny;
            if(map[nx][ny] == 'O') break;
        }

        nx = p.blueX;
        ny = p.blueY;

        while(true){
            nx = nx + dx[direction.ordinal()];
            ny = ny + dy[direction.ordinal()];

            if(!isMoved(nx, ny)) break;

            blueCnt++;
            blueX = nx;
            blueY = ny;
            if(map[nx][ny] == 'O') break;
        }

        if(redX == blueX && redY == blueY && map[redX][redY] != 'O'){
            if(redCnt > blueCnt){
                redX = redX - dx[direction.ordinal()];
                redY = redY - dy[direction.ordinal()];
            } else{
                blueX = redX - dx[direction.ordinal()];
                blueY = redY - dy[direction.ordinal()];
            }
        }

        return new Point(redX, redY, blueX, blueY);
    }

    public static boolean isValid(int redX, int redY, int blueX, int blueY){
        if(visited[redX][redY][blueX][blueY]) return false;

        return true;
    }

    public static boolean isMoved(int x, int y){
        return map[x][y] != '#';
    }

    public static class Point{
        int redX;
        int redY;
        int distance;

        int blueX;
        int blueY;

        Point(int redX, int redY, int distance, int blueX, int blueY){
            this.redX = redX;
            this.redY = redY;
            this.distance = distance;

            this.blueX = blueX;
            this.blueY = blueY;
        }

        Point(int redX, int redY, int blueX, int blueY){
            this.redX = redX;
            this.redY = redY;
            this.distance = 0;

            this.blueX = blueX;
            this.blueY = blueY;
        }
    }
}
