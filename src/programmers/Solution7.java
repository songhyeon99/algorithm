package programmers;

import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time=0;
        for(int i=0; i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                if(prices[i]<=prices[j]){
                    time++;
                }else{
                    time++;
                    break;
                }
            }
            answer[i]=time;
            time=0;
        }
        return answer;
    }
}
