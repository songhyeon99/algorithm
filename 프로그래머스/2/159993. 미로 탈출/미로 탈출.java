import java.io.*;
import java.util.*;

class Solution {
    static char[][] charMaps;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    
    public int solution(String[] maps) {
        charMaps = new char[maps.length][maps[0].length()];
        
        int startRow = 0; int startCol = 0;
        int lebberRow = 0; int lebberCol = 0;
        
        for(int i = 0; i<maps.length; i++) {
            String row = maps[i];
            for(int j = 0; j<maps[i].length(); j++ ) {
                charMaps[i][j] = row.charAt(j);
                if(row.charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                }
                if(row.charAt(j) == 'L') {
                    lebberRow = i;
                    lebberCol = j;
                }
            }
        }
        
        int toLebber = bfs(startRow, startCol, 'L', charMaps);
        if(toLebber == -1) return -1;
        int toEnd = bfs(lebberRow, lebberCol, 'E', charMaps);
        if(toEnd == -1) return -1;
        
        return toLebber + toEnd;
    }
    
    int bfs(int row, int col, char to, char[][] maps) {
        Queue<Position> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        q.add(new Position(row, col, 0));
        visited[row][col] = true;
        
        while(!q.isEmpty()) {
            Position current = q.poll();
            for(int i = 0 ; i<4; i++) {
                int newRow = dx[i] + current.row;
                int newCol = dy[i] + current.col;
                
                
                if(newRow >= 0 && newCol >= 0 && newRow < maps.length && newCol < maps[0].length) {
                    if(!visited[newRow][newCol] && maps[newRow][newCol] != 'X'){
                        q.add(new Position(newRow, newCol, current.count+1)); 
                        visited[newRow][newCol] = true;
                    }
                    if(maps[newRow][newCol] == to) {
                        return current.count+1;
                    }
                }
            }
        }
        return -1;
    }
    
    class Position {
        int row, col, count;
        
        Position(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}