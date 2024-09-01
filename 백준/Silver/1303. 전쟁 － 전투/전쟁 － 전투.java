import java.util.*;
import java.io.*;

public class Main {
	static int W = 0, B = 0, count = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visited = new boolean[M][N];
		for(int i = 0; i < M; i++){
			String str = br.readLine();
			for(int j = 0; j < N; j++){
				map[i][j] = str.charAt(j);
			}
		}

		for(int i = 0; i < M; i++){
			for(int j = 0; j<N; j++){
				if(!visited[i][j] && map[i][j] == 'W'){
					count = 1;
					DFS(i,j,'W');
					W += power(count);
				}else if(!visited[i][j] && map[i][j] == 'B'){
					count = 1;
					DFS(i,j,'B');
					B += power(count);
				}
			}
		}
		System.out.println(W+" "+B);
	}
	static void DFS(int x, int y, char c){
		visited[x][y] = true;
		for(int i = 0; i < dx.length; i++){
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny]){
				if(c == map[nx][ny]){
					visited[nx][ny] = true;
					count++;
					DFS(nx, ny, c);
				}
			}
		}
	}

	static int power(int n){
		return (int)Math.pow(n,2);
	}
}