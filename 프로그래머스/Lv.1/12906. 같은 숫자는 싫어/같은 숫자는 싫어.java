import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> numbers = new ArrayList<>();
        int num=-1;
        for(int i=0;i<arr.length;i++){
            if(num!=arr[i]) {
                num=arr[i];
                numbers.add(num);
                };
        }
        
         int[] answer = new int[numbers.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=numbers.get(i);
        }

        return answer;
    }
}