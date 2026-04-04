import java.util.*;
import java.io.*;

class Solution {
    static Map<Integer, List<Integer>> maps = new HashMap<>();
    static Queue<Integer> queue = new LinkedList<>();
    
    static boolean[] visited;
    static int[] count;
    
    static int max=-1;
    static int answer=0;
    
    public int solution(int n, int[][] edge) {
        count = new int[n+1];
        visited = new boolean[n+1];
        
        for(int i = 0; i<edge.length; i++ ){
            int key = edge[i][0];
            int value = edge[i][1];
            
            maps.putIfAbsent(key, new ArrayList<>());
            maps.putIfAbsent(value, new ArrayList<>());

            maps.get(key).add(value);
            maps.get(value).add(key);
        }
        queue.add(1);
        visited[1]=true;
        bfs();
        return answer;
    }
    
    public void bfs() {
        while(!queue.isEmpty()) {
            int cur = queue.poll();
                List<Integer> list = maps.get(cur);
                int len = list.size();

                for(int i = 0; i<len; i++) {
                    int connect = list.get(i);
                    if(!visited[connect]){
                        visited[connect] = true;
                        count[connect] = count[cur] + 1;
                        queue.add(connect);
                        if(max < count[connect]) {
                            max = count[connect];
                            answer = 1;
                        }else if(max == count[connect]) {
                            answer++;
                        }
                }
            }
        }
    }
}