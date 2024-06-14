import java.util.*;
import java.io.*;

public class Main {
	static int N, M, min;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean isChanged= false;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		map = new char[N+1][M+1];
		visited = new boolean[N+1][M+1][2];
		
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }
		
		System.out.println(bfs(1,1));
	}
	static int bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x,y,1,false));
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			if(current.x == N && current.y == M) {
				return current.count;
			}
			for(int i =0; i<4; i++) {
				int newX = dx[i] + current.x;
				int newY = dy[i] + current.y;
				
				if(newX > 0 && newY>0 && newX <=N&& newY <= M && map[newX][newY] == '1') {
					if(!current.isChanged) {
						visited[newX][newY][1] = true;
						queue.add(new Position(newX, newY, current.count+1, true));
					}
				}
				
				
				if(newX > 0 && newY>0 && newX <=N&& newY <= M && map[newX][newY] == '0') {
					if(!current.isChanged && !visited[newX][newY][0]) {
						visited[newX][newY][0] = true;
						queue.add(new Position(newX, newY, current.count+1, false));
					}else if(current.isChanged && !visited[newX][newY][1]){
						visited[newX][newY][1] = true;
						queue.add(new Position(newX, newY, current.count+1,true));
					}
				}
			}
		}
		return -1;
	}
	
	static class Position {
		int x, y, count;
		boolean isChanged;
		public Position(int x, int y, int count, boolean isChanged) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.isChanged = isChanged;
		}
	}
}