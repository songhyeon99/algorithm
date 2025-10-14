import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> cards1Queue = new LinkedList<>();
        for(int i = 0; i<cards1.length; i++){
            cards1Queue.add(cards1[i]);
        }
        
        Queue<String> cards2Queue = new LinkedList<>();
        for(int i = 0; i<cards2.length; i++){
            cards2Queue.add(cards2[i]);
        }
        
        answer = "Yes";
        for(int i = 0; i<goal.length; i++){
            if(!cards1Queue.isEmpty() && cards1Queue.peek().equals(goal[i])){
                cards1Queue.poll();
            }else if(!cards2Queue.isEmpty() && cards2Queue.peek().equals(goal[i])){
                cards2Queue.poll();
            }else{
                answer = "No";
            }
        }
        return answer;
    }
}