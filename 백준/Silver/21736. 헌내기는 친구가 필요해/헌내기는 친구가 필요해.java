import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, startX, startY, count = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i<N; i++){
			String str = br.readLine();
			for(int j = 0; j<M; j++){
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'I'){
					startX = i;
					startY = j;
				}
			}
		}
		BFS();
		System.out.println(count == 0 ? "TT" : count);
	}
	static void BFS(){
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(startX, startY));
		visited[startX][startY] = true;

		while(!queue.isEmpty()) {
			Position current = queue.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 'X'){
					if(!visited[nx][ny]){
						visited[nx][ny] = true;
						queue.add(new Position(nx, ny));
						if(map[nx][ny] == 'P'){
							count++;
						}
					}
				}
			}
		}
	}

	static class Position {
		int x, y;
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}