import java.io.*;
import java.util.*;

class Solution {
    static Queue<Position> q;
    static boolean[][] visited;
    static int[][] count;
    
    static int row;
    static int col;
    static int answer;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        
        row = maps.length;
        col = maps[0].length;
        answer = -1;
        
        q = new LinkedList<>();
        visited = new boolean[row][col];
        count = new int[row][col];
        
        return bfs(maps, 0, 0);
    }
    
    static int bfs(int[][] maps, int x, int y) {
        q.add(new Position(x, y));
        
        while(!q.isEmpty()){
            Position existPosition = q.poll();
            for(int i = 0; i<4; i++){
                int newX = existPosition.x + dx[i];
                int newY = existPosition.y + dy[i];

                if(newX >= 0 && newY >= 0 && newX < row && newY < col) {
                    if(!visited[newX][newY] && maps[newX][newY] != 0) {
                        q.add(new Position(newX, newY));
                        visited[newX][newY] = true;
                        count[newX][newY] = count[existPosition.x][existPosition.y]+1;
                    }else if(visited[newX][newY] && maps[newX][newY] != 0) {
                        count[newX][newY] = Math.min(count[newX][newY], count[existPosition.x][existPosition.y]+1);
                    }
                }
            }
        }
        answer = count[row-1][col-1] != 0 ? count[row-1][col-1] + 1 : answer;
        return answer;
    }
    
    static class Position {
        int x;
        int y;
        
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}