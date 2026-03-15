import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int currentIdx = stack.pop();
                answer[currentIdx] = i - currentIdx;
            }
                stack.push(i);
            
        }
        
        int stackSize = stack.size();
        for(int i = 0; i<stackSize; i++) {
                int currentIdx = stack.pop();
                answer[currentIdx] = prices.length - 1 - currentIdx;
        }
        return answer;
    }
}