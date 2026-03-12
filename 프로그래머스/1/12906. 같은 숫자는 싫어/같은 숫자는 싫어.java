import java.util.*;

public class Solution {
    public Integer[] solution(int []arr) {
        List<Integer> answerList = new ArrayList<>();
        
        int current = -1;
        int prev = -1;
        
        for(int i = 0; i<arr.length; i++) {
            current = arr[i];
            if(current != prev){
                answerList.add(arr[i]);
            }
            prev = current;
        }
        
        return answerList.toArray(new Integer[answerList.size()]);
    }
}