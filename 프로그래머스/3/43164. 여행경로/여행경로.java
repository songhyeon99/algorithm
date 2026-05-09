import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        dfs("ICN", answer, tickets, 0);
        
        String[] arr = answer.stream()
            .toArray(String[]::new);
        
        
        return arr;
    }
    
    boolean dfs(String start, List<String> answer, String[][] tickets, int count) {  
        answer.add(start);
        if(count == tickets.length) return true;
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                if(dfs(tickets[i][1], answer, tickets, count + 1)){
                    return true;
                }
                answer.remove(answer.size() - 1);
                visited[i] = false;
            }
        }
        return false;
    }
}