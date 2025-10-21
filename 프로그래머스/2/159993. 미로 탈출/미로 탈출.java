import java.util.*;
import java.io.*;

class Solution {
    static char[][] map;
    static int[][] count;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        count = new int[maps.length][maps[0].length()];
        
        int startXForS = 0; int startYForS = 0;
        int startXForL = 0; int startYForL = 0;
        
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    startXForS = i;
                    startYForS = j;
                }
                if(map[i][j] == 'L') {
                    startXForL = i;
                    startYForL = j;
                }
            }
        }
        
        int toLever = bfs(startXForS, startYForS, 'L');
        if(toLever == -1) return -1; 
        
        int toExit = bfs(startXForL, startYForL, 'E');
        if(toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    public static int bfs(int x, int y, int destination){
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x,y, 0));
        
        while(!queue.isEmpty()) {
            Position position = queue.poll();
            // if (map[position.x][position.y] == destination) return position.count;
            for(int i = 0; i<4; i++){
                int nx = dx[i] + position.x;
                int ny = dy[i] + position.y;

                if(nx >= 0 && nx <map.length && ny >= 0 && ny < map[0].length && 
                   !visited[nx][ny] && map[nx][ny] != 'X'
                ) {
                    if(map[nx][ny] == destination) {
                            return position.count + 1;
                    }else {
                        visited[nx][ny] = true;
                        queue.add(new Position(nx, ny, position.count+1));
                    }
                }
            }
        }
        return -1;
    }
    
   static class Position {
        int x;
        int y;
        int count;
        
        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}