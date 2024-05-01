import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static Queue<Position> queue;
    static int col, row, day = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        col = sc.nextInt();
        row = sc.nextInt();
        map = new int[row][col];
        queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1){
                    queue.add(new Position(i,j));
                }
            }
        }

        dfs();
        System.out.println(day);
    }

    static void dfs() {
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newCol = position.col + dx[i];
                int newRow = position.row + dy[i];

                if (newCol >= 0 && newRow >= 0 && newRow < row && newCol < col && map[newRow][newCol] == 0) {
                    queue.add(new Position(newRow, newCol));
                    map[newRow][newCol] = map[position.row][position.col] + 1;
                }
            }
        }
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(map[i][j] == 0){
                    day = -1;
                    return;
                }
                day = Math.max(day, map[i][j]);
            }
        }

        if(day == 1){
            day = 0;
        }else if(day > 1){
            day -= 1;
        }
    }

    static class Position{
        int row, col;
        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}