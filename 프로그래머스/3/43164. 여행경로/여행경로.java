import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    List<String> answer = new ArrayList<>();
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs(tickets, "ICN", path, 0);
        
        String[] arr = answer.stream()
                             .toArray(String[]::new);
        
        return arr;
    }
    
    void dfs(String[][] tickets, String current, List<String> path, int count) {
        if (found) return;

        if (count == tickets.length) {
            answer = new ArrayList<>(path);
            found = true;
            return;
        }
        
        for(int i = 0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets, tickets[i][1], path, count+1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}