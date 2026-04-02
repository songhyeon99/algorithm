import java.io.*;
import java.util.*;

class Solution {
    static int answer = 0;
    static int length;
    public int solution(int[] numbers, int target) {
        length = numbers.length;
        
        dfs(0, target, 0, numbers);
        
        return answer;
    }
    
    static void dfs (int idx, int target, int sum, int[]numbers) {
        if(idx == length-1){
            int sum1 = sum + numbers[idx];
            int sum2 = sum - numbers[idx];
            if(sum1 == target) {
                answer++;
            }
            if(sum2 == target) {
                answer++;
            }
            return;
        }
        if(idx >= length ) {
            return;
        }
        int curNumber = numbers[idx];
        dfs(idx+1, target, sum+curNumber, numbers);
        dfs(idx+1, target, sum-curNumber, numbers);
    }
}