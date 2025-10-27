import java.util.*;
import java.io.*;

class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        String[][] sortedPlans = Arrays.stream(plans)
            .sorted((a, b) -> a[1].compareTo(b[1]))
            .toArray(String[][]::new);
        
        for(int i = 0; i<plans.length; i++) {
            map.put(plans[i][0], Integer.valueOf(plans[i][2]));
        }
        
        stack.push(sortedPlans[0][0]);
        String[] currentTime = sortedPlans[0][1].split(":");
        int currentHour = Integer.valueOf(currentTime[0]);
        int currentMinute = Integer.valueOf(currentTime[1]);
        int currentTotalTime = currentHour * 60 + currentMinute;
        
        for(int i = 1; i<sortedPlans.length;i++){
            String[] nextTime = sortedPlans[i][1].split(":");
            int nextHour = Integer.valueOf(nextTime[0]);
            int nextMinutes = Integer.valueOf(nextTime[1]);
            int nextTotalTime = nextHour * 60 + nextMinutes;
            
            int remain = nextTotalTime - currentTotalTime;
            
            while(!stack.isEmpty() && remain > 0) {
                String plan = stack.pop();
                int duration = map.get(plan);
                
                if (remain >= duration) {
                    answer.add(plan);
                    remain -= duration;
                    currentTotalTime += duration;
                }else{
                    map.put(plan, duration-remain);
                    currentTotalTime += remain;
                    stack.push(plan);
                    remain = 0;
                }
            }
            stack.push(sortedPlans[i][0]);
            currentTotalTime = nextTotalTime;
        }
        
        while(!stack.isEmpty()){
            answer.add(stack.pop());
        }
            
        return answer;
    }
}