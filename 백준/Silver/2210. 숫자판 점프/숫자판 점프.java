import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<String> result = new HashSet<>();
	static int[][] arr = new int[5][5];

	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 5; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dfs(i, j, String.valueOf(arr[i][j]),0);
			}
		}

		System.out.println(result.size());
	}

	static void dfs(int start, int end, String str, int count){
		if(count == 5) {
			result.add(str);
			return;
		}

		for(int i = 0; i<4; i++) {
				int nx = start + dx[i];
				int ny = end + dy[i];

				if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
					dfs(nx, ny,str+String.valueOf(arr[nx][ny]), count+1);
				}
			}
		}
	}
