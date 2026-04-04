import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        
        for(int i = 0; i < lost.length; i++) {
            lostList.add(lost[i]);
        }
        
        for(int i = 0; i < reserve.length; i++) {
            reserveList.add(reserve[i]);
        }
        
        for(int i = 0; i< lost.length; i++) {
            if(reserveList.contains(lost[i])) {
                reserveList.remove(Integer.valueOf(lost[i]));
            }
        }
        for(int i = 0; i< reserve.length; i++) {
            if(lostList.contains(reserve[i])) {
                lostList.remove(Integer.valueOf(reserve[i]));
            }
        }
        
        Collections.sort(lostList);
        Collections.sort(reserveList);
        
        answer = reserveList.size();
        
        for(int i = 1; i<=n; i++) {
            if(reserveList.contains(i)) {
                if(lostList.contains(i-1) && !visited[i-1]) {
                    reserveList.remove(Integer.valueOf(i));
                    visited[i-1] = true;
                    answer++;
                }else if(lostList.contains(i+1) && !visited[i+1]) {
                    reserveList.remove(Integer.valueOf(i));
                    visited[i+1] = true;
                    answer++;
                }
            }else if(!reserveList.contains(i) && !lostList.contains(i)) {
                answer++;
            }
        }
        return answer;
    }
}