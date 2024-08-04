import java.util.*;
class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static Set<Integer> set;
    static List<Group> groups;
    static boolean[][] visited;
    static int n, m, count;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        int[] result = new int[m];
        int max = 0;
        groups = new ArrayList<>();
        visited = new boolean[n][m];
        
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (land[i][j] == 1 && !visited[i][j]) {
                    count = 1;
					groups.add(bfs(i, j, land));
				}
			}
		}
        
        for(int i = 0; i<groups.size(); i++){
            for(Integer j : groups.get(i).set){
                result[j] += groups.get(i).count;
                max = Math.max(max, result[j]);
            }
        }
        return max;
    }
    
    static Group bfs(int x, int y, int[][] land){ 
        Queue<Position> queue = new LinkedList<>();
        set = new HashSet<>();
        queue.add(new Position(x,y));
        visited[x][y] = true;
        set.add(y);
        while(!queue.isEmpty()){
            Position current = queue.poll();
       for(int i = 0; i<dx.length; i++){
           int nx = dx[i] + current.x;
           int ny = dy[i] + current.y;
           
           if(nx >=0 && ny >= 0 && nx < n && ny < m && land[nx][ny] == 1 && !visited[nx][ny]){
                   visited[nx][ny] = true;
                   count++;
                   queue.add(new Position(nx, ny));
                   set.add(ny);
           }
       }
        }
        return new Group(count, set);
    }
    
    static class Position{
        int x, y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static class Group{
        int count;
        Set<Integer> set;
        
        public Group(int count, Set<Integer> set){
            this.count = count;
            this.set = set;
        }
    }
}